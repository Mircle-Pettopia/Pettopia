package com.yedam.pettopia.user.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.JsonElement;
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
		System.out.println(vo);
		
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
	public String getAccessToken(String authorize_code) {
        String access_Token = "";
        String refresh_Token = "";
        String reqURL = "https://kauth.kakao.com/oauth/token";
        
        /*try {
			URL url = new URL(reqURL);
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            //POST 요청을 위해 기본값이 false인 setDoOutput을 true로
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);

            //POST 요청에 필요로 요구하는 파라미터 스트림을 통해 전송
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            StringBuilder sb = new StringBuilder();
            sb.append("grant_type=authorization_code");
            sb.append("&client_id=730975601d99f3b911f8fb8fff4edafa");  //본인이 발급받은 key
            sb.append("&redirect_uri=http://localhost:8080/login");     // 본인이 설정해 놓은 경로
            sb.append("&code=" + authorize_code);
            bw.write(sb.toString());
            bw.flush();

            //결과 코드가 200이라면 성공
            int responseCode = conn.getResponseCode();
            System.out.println("responseCode : " + responseCode);

            //    요청을 통해 얻은 JSON타입의 Response 메세지 읽어오기
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = "";
            String result = "";

            while ((line = br.readLine()) != null) {
                result += line;
            }
            System.out.println("response body : " + result);

            //Gson 라이브러리에 포함된 클래스로 JSON파싱 객체 생성
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(result);

            access_Token = element.getAsJsonObject().get("access_token").getAsString();
            refresh_Token = element.getAsJsonObject().get("refresh_token").getAsString();

            System.out.println("access_token : " + access_Token);
            System.out.println("refresh_token : " + refresh_Token);

            br.close();
            bw.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}*/
		return null;

	};
	
}
