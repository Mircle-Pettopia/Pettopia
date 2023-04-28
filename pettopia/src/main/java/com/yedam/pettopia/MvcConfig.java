package com.yedam.pettopia;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		//registry.addViewController("/homeTest").setViewName("homeTest");
		
		//메인페이지
		registry.addViewController("/").setViewName("index");
		
		//registry.addViewController("/hello").setViewName("hello");
		
		//로그인페이지
		registry.addViewController("/login").setViewName("login");
		
		//회원가입페이지
		registry.addViewController("/signUp").setViewName("signUp");
	}
}
