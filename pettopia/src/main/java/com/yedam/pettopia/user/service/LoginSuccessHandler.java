package com.yedam.pettopia.user.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res,
										Authentication authdata) throws IOException, ServletException {
        String uri = "";
        
        //로그인한 아이디 권한확인하기
        System.out.println(authdata.getAuthorities().toString());
        	
    	//참고 URL : https://okky.kr/questions/1132748
    	switch (authdata.getAuthorities().toString()) {
			case "[ROLE_ADMIN]":
				uri += "http://localhost:81/productMag";
				break;
			case "[ROLE_USER]":
				uri = "http://localhost:81/";
			break;
        }
        
        res.sendRedirect(uri);
	};
	
	/* 보면 좋을 거 같은 URL : https://velog.io/@bey1548/Spring-Security-로그인-성공-대응-로직 */
}
