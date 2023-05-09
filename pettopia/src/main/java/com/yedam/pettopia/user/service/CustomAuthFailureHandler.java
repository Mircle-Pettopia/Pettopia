package com.yedam.pettopia.user.service;


import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.yedam.pettopia.user.UserVO;
import com.yedam.pettopia.user.auth.PrincipalDetails;

import lombok.Data;

@Component
public class CustomAuthFailureHandler extends SimpleUrlAuthenticationFailureHandler{
	/*
	 * HttpServletRequest : request 정보
	 * HttpServletResponse : Response에 대해 설정할 수 있는 변수
	 * AuthenticationException : 로그인 실패 시 예외에 대한 정보
	 */
	
	@Autowired
	UserService service;
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		String errorMessage;
		
		// 참고 URL : https://gaebalsaebal-developer.tistory.com/4
		// 로그인 id, pw 값 받아오기
		String id = request.getParameter("meId");
		String pw = request.getParameter("password");
		
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        UserVO idChk = service.getUserAccount(id);
        System.out.println(idChk);
        String yn = idChk.getOutYn();
        /*String dbPw = idChk.getPw();
        
        boolean pwResult = encoder.matches(pw, dbPw);
        System.out.println(pwResult);
        int result = service.userDelNotLogin(id, dbPw); */

        System.out.println("yn====" + yn);
		if(exception instanceof BadCredentialsException ) {
			if(yn == "Y") {
				errorMessage = "test";
			} else {
				errorMessage = "아이디 또는 비밀번호가 맞지 않습니다. 다시 확인해주세요.";
			}
		} else if (exception instanceof UsernameNotFoundException || exception instanceof InternalAuthenticationServiceException) {
			errorMessage = "존재하지 않는 계정입니다. 회원가입 후 로그인해주세요.";
		} else if (exception instanceof AuthenticationCredentialsNotFoundException) {
			errorMessage = "인증 요청이 거부되었습니다. 관리자에게 문의하세요.";
		}  else {
			errorMessage = "알 수 없는 오류로 로그인 요청을 처리할 수 없습니다. 관리자에게 문의하세요.";
		}
		
		
		errorMessage = URLEncoder.encode(errorMessage, "UTF-8"); /* 한글 인코딩 깨진 문제 방지 */
		setDefaultFailureUrl("/login?error=true&exception="+errorMessage);
		super.onAuthenticationFailure(request, response, exception);
	}
}