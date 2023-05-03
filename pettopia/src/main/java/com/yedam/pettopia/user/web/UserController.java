package com.yedam.pettopia.user.web;

import java.util.HashMap;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yedam.pettopia.user.UserVO;
import com.yedam.pettopia.user.service.UserServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController { 
	
	private final UserServiceImpl service;
	
	@GetMapping("/")
	public String main(Model model, Authentication authentication){
		return "index";
	}
	
	@GetMapping("/main")
	public String mainLogin(Model model, Authentication authentication){
		//Authentication 객체를 통해 유저 정보를 가져올 수 있다.
        UserVO userVo = (UserVO) authentication.getPrincipal();  //userDetail 객체를 가져옴
        
        model.addAttribute("id", userVo.getMeId());      //유저 아이디*/
        model.addAttribute("name", userVo.getName());     //유저 이름*/
        
        System.out.println(model);
		
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
	
	@GetMapping("/kakaologin")
	public ModelAndView kakaoLogin(@RequestParam(value = "code", required = false) String code) throws Throwable {
		//카카오 // 1번
		System.out.println("code:" + code);
		
		// 2번
		String access_Token = service.getAccessToken(code);
		System.out.println("###access_Token#### : " + access_Token);
		// 위의 access_Token 받는 걸 확인한 후에 밑에 진행
		
		// 3번
		/*HashMap<String, Object> userInfo = service.getUserInfo(access_Token);
		
		System.out.println("###id#### : " + userInfo.get("id"));
		System.out.println("###nickname#### : " + userInfo.get("nickname"));
		System.out.println("###email#### : " + userInfo.get("email"));*/
		
		return null;
	};
    
    @GetMapping("/signUp")
    public String signUp() {
        return "signUp";
    };
	
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
