package com.yedam.pettopia.user.service;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.yedam.pettopia.user.UserVO;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler{
	
	@Autowired
	UserService service;
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res,
										Authentication authdata) throws IOException, ServletException {
        String uri = "";
        String id = req.getParameter("meId");
		String pw = req.getParameter("password");
		String message = "";
		
		System.out.println("id, pw ======" + id + ", " + pw);
		
		UserVO idChk = service.getUserAccount(id);
        String yn = idChk.getOutYn();
        
        // 로그인한 아이디 권한 확인하기
        //System.out.println(authdata.getAuthorities().toString());
        
        // 회원탈퇴 여부 확인하기
        //System.out.println(yn.equals("Y"));
        
        // 탈퇴된 아이디로 로그인을 시도할 시 로그인실패핸들러 시늉하기
        if(yn.equals("Y")) {
        	message = "탈퇴된 아이디는 로그인이 불가합니다.";
        	message = URLEncoder.encode(message, "UTF-8"); // 한글 인코 깨진 문제 방지
        	uri += "http://localhost:81/login?error=true&exception=" + message;
        // 그게 아니라면 정상 로그인 시키기
        } else {
	    	//참고 URL : https://okky.kr/questions/1132748
	    	switch (authdata.getAuthorities().toString()) {
	    		// 권한이 ADMIN이면 어드민 페이지로 이동
				case "[ROLE_ADMIN]":
					uri += "http://localhost:81/productMag";
					break;
				// 권한이 USER면 메인 페이지로 이동
				case "[ROLE_USER]":
					uri = "http://localhost:81/";
				break;
	        }
        }
        
        // 위의 결과에 맞춰 uri 변수가 담은 주소를 리다이렉트
        res.sendRedirect(uri);
	}
	
	/* 보면 좋을 거 같은 URL : https://velog.io/@bey1548/Spring-Security-로그인-성공-대응-로직 */
}
