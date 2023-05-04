package com.yedam.pettopia.user.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yedam.pettopia.user.UserVO;
import com.yedam.pettopia.user.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService, UserService{
	/*SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd HH:mm:ss");
    Date time = new Date();
    String localTime = format.format(time);*/
	
	@Autowired
    private final UserMapper mapper;

	@Transactional
	public int joinUser(UserVO vo) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		vo.setPw(passwordEncoder.encode(vo.getPassword()));
		vo.setRole("USER");
		
		int result = mapper.saveUser(vo);
		if(result < 1) {
			result = -1;
		}
		
		return result;
	};
	
	@Override
	public UserVO loadUserByUsername(String meId) throws UsernameNotFoundException {
		//여기서 받은 유저 패스워드와 비교하여 로그인 인증
		UserVO vo = mapper.getUserAccount(meId);
		
        if (vo == null){
            throw new UsernameNotFoundException("User not authorized.");
        };
        
		return vo;
	};
	
	//아이디 중복확인
	public int idChk(String meId) {
		return mapper.idChk(meId);
	}

	@Override
	public UserVO getUserAccount(String meId) {
		return mapper.getUserAccount(meId);
	}
	
	//kakao login
	@Override
	public String getAccessToken(String authorize_code) throws Exception {
        String access_Token = "";
        String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";
        
        try {
			URL url = new URL(reqURL);
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //POST 요청을 위해 기본값이 false인 setDoOutput을 true로
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            //POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=ac331cbe1745422549605be16be6ce42");  //발급받은 key
            sb.append("&redirect_uri=http://localhost:81/kakaologin");      //설정해 놓은 경로
            sb.append("&code=" + authorize_code);
            bw.write(sb.toString());
            bw.flush();

            //결과 코드가 200이라면 성공
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            //요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("getAccessToken response body : " + result);

            /* -->Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성 : Gson이 제대로 작동되지 않아 jackson으로 진행했음.
             * JsonParser parser = new JsonParser();
             * JsonElement element = parser.parse(result);
             * 출처 : https://makeaplayground.tistory.com/m/158
             */
            
            //jackson objectmapper 객체 생성
            ObjectMapper objectMapper = new ObjectMapper();
            //JSON String -> Map
 			Map<String, Object> jsonMap = objectMapper.readValue(result, new TypeReference<Map<String, Object>>() {
 			});

 			access_Token = jsonMap.get("access_token").toString();
			refresh_Token = jsonMap.get("refresh_token").toString();

			System.out.println("getAccessToken access_token : " + access_Token);
			System.out.println("getAccessToken refresh_token : " + refresh_Token);

			br.close();
			bw.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
        
		return access_Token;
	}

	@SuppressWarnings("unchecked")
	@Override
	public HashMap<String, Object> getUserInfo(String access_Token) throws Throwable {
		// 요청하는 클라이언트마다 가진 정보가 다를 수 있기에 HashMap타입으로 선언
		HashMap<String, Object> userInfo = new HashMap<String, Object>();
		String reqURL = "https://kapi.kakao.com/v2/user/me";
		
		try {
			URL url = new URL(reqURL);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("GET");
			
			// 요청에 필요한 Header에 포함될 내용
			conn.setRequestProperty("Authorization", "Bearer " + access_Token);

			//상태코드 확인 : 200
			//int responseCode = conn.getResponseCode();
			//System.out.println("responseCode : " + responseCode); 

			BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String line = "";
			String result = "";

			while ((line = br.readLine()) != null) {
				result += line;
			}
			System.out.println("response body : " + result);
			//System.out.println("result type" + result.getClass().getName()); // java.lang.String

			// jackson objectmapper 객체 생성
			ObjectMapper objectMapper = new ObjectMapper();
			
			// JSON String -> Map
			Map<String, Object> jsonMap = objectMapper.readValue(result, new TypeReference<Map<String, Object>>() {
			});
			
			//System.out.println("----------"+String.valueOf(jsonMap.get("id")));
			//System.out.println("----------"+jsonMap.get("properties"));
			//System.out.println("----------"+jsonMap.get("kakao_account"));
			
			String id_2 = String.valueOf(jsonMap.get("id"));	//2774080852
			String id = "{\"id\":" + "\""+id_2+"\"}";			//{"id":"2774080852"}
			String obj = "{id=" + id_2 + "}";					//{id=2774080852}
			Map<String, Object> properties = (Map<String, Object>) jsonMap.get("properties");
			Map<String, Object> kakao_account = (Map<String, Object>) jsonMap.get("kakao_account");
			
			/*System.out.println("id===" + id_2);
			System.out.println("별명===" + properties.get("nickname"));
			System.out.println("이메일===" + kakao_account.get("email"));*/
			
			String nickname = properties.get("nickname").toString();
			String email = String.valueOf(kakao_account.get("email"));
			if("null".equals(email)) {
				//System.out.println("없음");
				email = "null";
			} else {
				//System.out.println(email);
				email = kakao_account.get("email").toString();
			}
			
			userInfo.put("id", id_2);
			userInfo.put("nickname", nickname);
			userInfo.put("email", email);

		} catch (IOException e) {
			e.printStackTrace();
		}
		return userInfo;
	}

	//DB에 해당되는 카카오 아이디 토큰이 있는지 없는지 확인하기
	@Override
	public UserVO snsIdTokenChk(Object id) {
		return mapper.snsIdTokenChk(id);
	}
	
	//카카오 회원가입
	@Override
	public int kakaosaveUser(UserVO vo) {
		/*BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		vo.setPw(passwordEncoder.encode(vo.getPassword()));*/
		
		int result = mapper.kakaosaveUser(vo);
		if(result < 1) {
			result = -1;
		};
		
		return result;
	};
	
}
