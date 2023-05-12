package com.yedam.pettopia.user.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.pettopia.user.UserVO;
import com.yedam.pettopia.user.auth.PrincipalDetails;
import com.yedam.pettopia.user.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	private final UserService service;
	private final PasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/login")
    public String login() {
		/*String uri = request.getHeader("Referer");
		
		if(!uri.contains("/login")){
	    	request.getSession().setAttribute("prevPage", uri);
	    }*/

		/* 에러와 예외를 모델에 담아 view resolve */
		/*model.addAttribute("error", error);
		model.addAttribute("exception", exception);*/
		
    	return "login";
	};
    
    @GetMapping("/loginInfo")
    @ResponseBody
    public String loginInfo(Authentication authentication){
        String result = "";

        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        if(principal.getUser().getProvider() == null) {
            result = result + "Form 로그인 : " + principal;
            //System.out.println("form로그인===" + result);
        }else{
            result = result + "OAuth2 로그인 : " + principal;
            //System.out.println("OAuth2로그인===" + result);
        }
        return result; 
    }
	
    //회원가입페이지
    @GetMapping("/signUp")
    public String signUp() {
        return "signUp";
    };
	
    //자사기준 회원가입처리
	@PostMapping("/signUp")
	@ResponseBody
    public Boolean signUp(@RequestBody UserVO userVo) {
		Boolean result = false;
		
		if(service.joinUser(userVo) > 0) {
			result = true;
		};
		
        return result;
    };
    
    //아이디 중복체크
    @PostMapping("/idChk")
    public @ResponseBody int idChk(String meId) {
    	int result = service.idChk(meId);
    	return result;
    };
    
    @PostMapping("/snsTokenChk")
    @ResponseBody
    public Boolean snsTokenChk(String meSnsToken) {
    	Boolean result = false;
    	UserVO info = service.snsGetNullInfo(meSnsToken);
    	String a = info.getAddr();
    	String b = info.getPost();
    	String c = info.getPhone();
    	System.out.println(a);
    	System.out.println(a == "null");
    	System.out.println(a.equals("null"));
    	//주소 상세는 없을 수 있기 때문에 뺐다.
    	if(a == "null" || b == "null" || c == "null") {
    		//정보가 없을 때 트루를 반환한다.
    		result = true;
    	};
    	
    	return result;
    };
    
    @GetMapping("userInfo")
    public String userInfo(Model model,
							@AuthenticationPrincipal PrincipalDetails principal) {
        String id = principal.getUser().getMeId();
        model.addAttribute("name", principal.getUser().getName());
        model.addAttribute("id", principal.getUser().getMeId());
        model.addAttribute("path", principal.getUser().getSignPath());
        model.addAttribute("role", principal.getUser().getRole());
        model.addAttribute("info", service.getUserAccount(id));
    	return "mypage/userInfo";
    }
    
    //비밀번호체크
    @PostMapping("pwChk")
    @ResponseBody
    public boolean pwChk(@RequestParam String pw,
    		             @AuthenticationPrincipal PrincipalDetails principal) {
    	
    	String prinId = principal.getUser().getMeId();
    	
    	//단건조회
    	UserVO meIdChk = service.getUserAccount(prinId);
    	String pwchk = meIdChk.getPw();
    	
    	//패스워드비교
    	boolean result = bCryptPasswordEncoder.matches(pw,pwchk);
    	
    	return result;
    };
    
    //정보 업데이트
    @PutMapping("userInfoUpdate")
    @ResponseBody
    public boolean userInfoUpdate(@RequestBody UserVO vo) {
    	boolean response = true;
		int result = service.userInfoUpdate(vo);
		if(result < 0) {
			response = false;
		}
    	return response;
    };
    
    //회원탈퇴
    @PostMapping("userDtl")
    @ResponseBody
    //HttpSession session,
    public boolean userDtl(@RequestParam String meId) {
    	boolean respons = false;
    	
    	//UserVO vo = (UserVO) session.getAttribute("loginUser");
    	int result = service.userDelete(meId);
    	
    	if(result == 1) {
    		respons = true;
    	}
    	
    	return respons;
    }


	
    /*// !!!! OAuth로 로그인 시 이 방식대로 하면 CastException 발생함
    @GetMapping("/form/loginInfo")
    @ResponseBody
    public String formLoginInfo(Authentication authentication, @AuthenticationPrincipal PrincipalDetails principalDetails){

        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        UserVO user = principal.getUser();
        System.out.println(user);
        //User(id=2, username=11, password=$2a$10$m/1Alpm180jjsBpYReeml.AzvGlx/Djg4Z9/JDZYz8TJF1qUKd1fW, email=11@11, role=ROLE_USER, createTime=2022-01-30 19:07:43.213, provider=null, providerId=null)

        UserVO user1 = principalDetails.getUser();
        System.out.println(user1);
        //User(id=2, username=11, password=$2a$10$m/1Alpm180jjsBpYReeml.AzvGlx/Djg4Z9/JDZYz8TJF1qUKd1fW, email=11@11, role=ROLE_USER, createTime=2022-01-30 19:07:43.213, provider=null, providerId=null)
        //user == user1

        return user.toString();
   }
    
    @GetMapping("/oauth/loginInfo")
    @ResponseBody
    public String oauthLoginInfo(Authentication authentication, @AuthenticationPrincipal OAuth2User oAuth2UserPrincipal){
        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        Map<String, Object> attributes = oAuth2User.getAttributes();
        System.out.println(attributes);
        // PrincipalOauth2UserService의 getAttributes내용과 같음

        Map<String, Object> attributes1 = oAuth2UserPrincipal.getAttributes();
        // attributes == attributes1

       return attributes.toString();     //세션에 담긴 user가져올 수 있음음
    }*/
    
}
