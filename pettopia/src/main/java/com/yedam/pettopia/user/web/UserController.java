package com.yedam.pettopia.user.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.pettopia.user.UserVO;
import com.yedam.pettopia.user.auth.PrincipalDetails;
import com.yedam.pettopia.user.service.UserServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController { 
	private final UserServiceImpl service;
	
	//, Authentication authentication
	@GetMapping("/main")
	public String mainLogin(@AuthenticationPrincipal PrincipalDetails principalDetails,
							Authentication authentication, Model model){
		//Authentication 객체를 통해 유저 정보를 가져올 수 있다.
        
        
		String result = "";
		PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
		
		System.out.println("어느소속이냐=====" + principal.getUser().getSignPath());
		//카카오는 잘 들어가지는데 자사 폼으로 로그인하면 페이지 이동이되지 않음
        if(principal.getUser().getSignPath() == "company") {
        	result += principal;
            System.out.println("form로그인===" + result);
            //model.addAttribute("formResult", result);
            
            model.addAttribute("id", principal.getUser().getMeId());
            model.addAttribute("name", principal.getUser().getName());
            
            System.out.println(model);
        }else{
        	result += principal;
            System.out.println("OAuth2로그인===" + result);
            
            model.addAttribute("id", principal.getUser().getMeId());
            model.addAttribute("name", principal.getUser().getName());
        }
        
		return "index";
	};
	
	@GetMapping("/login")
    public String login(@RequestParam(value="error", required = false) String error,
    					@RequestParam(value="exception", required = false) String exception,
    					Model model) {

		/* 에러와 예외를 모델에 담아 view resolve */
		model.addAttribute("error", error);
		model.addAttribute("exception", exception);
		
    	return "login";
	};
	
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
    
    @GetMapping("/loginInfo")
    @ResponseBody
    public String loginInfo(Authentication authentication, @AuthenticationPrincipal PrincipalDetails principalDetails){
        String result = "";

        PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        if(principal.getUser().getProvider() == null) {
            result = result + "Form 로그인 : " + principal;
            System.out.println("form로그인===" + result);
        }else{
            result = result + "OAuth2 로그인 : " + principal;
            System.out.println("OAuth2로그인===" + result);
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
    
    
}
