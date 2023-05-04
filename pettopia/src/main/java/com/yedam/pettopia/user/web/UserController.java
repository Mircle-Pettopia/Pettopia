package com.yedam.pettopia.user.web;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yedam.pettopia.user.UserVO;
import com.yedam.pettopia.user.service.UserServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController { 
	
	private final AuthenticationManager authenticationManager;
	private final UserServiceImpl service;

	
	/*
	 * @GetMapping("/") public String main(Model model, Authentication
	 * authentication){
	 * 
	 * return "index"; }
	 */
   
	
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
	
	//카카오
	@GetMapping("/kakaologin")
	public String kakaoLogin(@RequestParam(value = "code", required = false) String code) throws Throwable {
		// 1번
		//System.out.println("code:" + code);
		
		// 2번
		String access_Token = service.getAccessToken(code);
		//System.out.println("###access_Token#### : " + access_Token);
		// 위의 access_Token 받는 걸 확인한 후에 밑에 진행
		
		// 3번
		HashMap<String, Object> userInfo = service.getUserInfo(access_Token);
		
		System.out.println("###id#### : " + userInfo.get("id"));
		//System.out.println("###nickname#### : " + userInfo.get("nickname"));
		//System.out.println("###email#### : " + userInfo.get("email"));
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		Object nickname = userInfo.get("nickname");
		Object id = userInfo.get("id");
		Object email = userInfo.get("email");
		Object emailChk = String.valueOf(userInfo.get("email"));
		
		System.out.println("이메일:" + email);
		System.out.println("emailChk:" + emailChk);
		
		//ModelAndView mv = new ModelAndView();
		UserVO kakaoMember = service.snsIdTokenChk(id);
		
		UserVO vos= new UserVO();
		
		//DB에 해당되는 카카오 아이디 토큰이 없을 경우 회원가입 시켜버린다.
		if(kakaoMember == null) {
			System.out.println("아이디가 없다");
			
			CharSequence password = id + "kakao";
			String encodedPassword = passwordEncoder.encode(password);
			 
			//이메일이 없을 경우 아이디 토큰으로 대체
			if(emailChk == "null") {
				System.out.println("이메일없다");
				vos.setMeId(id.toString());
			//이메일이 존재하면 이메일로 가입진행
			} else {
				System.out.println("이메일있다");
				vos.setMeId(String.valueOf(email));
			};	
			
			vos.setPw(String.valueOf(encodedPassword));  //비밀번호 암호화
			vos.setName(String.valueOf(nickname));		//카카오별명
			vos.setMeSnsToken(id.toString());
			 
			service.kakaosaveUser(vos);
		}
		
		
		// 로그인 처리
        Authentication kakaoUsernamePassword = new UsernamePasswordAuthenticationToken(vos.getMeId(), vos.getPw());
        Authentication authentication = authenticationManager.authenticate(kakaoUsernamePassword);
        SecurityContextHolder.getContext().setAuthentication(authentication);

		//ModelAndView
		//mv.setViewName("/main"); 		   // 뷰의 이름
		//mv.addObject("data", userInfo); // 뷰로 보낼 데이터 값
		
		return "redirect:/main";
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
