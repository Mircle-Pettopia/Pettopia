package com.yedam.pettopia;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	//패스워드 인코딩
	@Bean	//<bean id="" class="">
	public PasswordEncoder bcryptPassword() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests((requests) -> requests
							.antMatchers("/homeTest","/","/css/**","/js/**","/img/**","/**").permitAll()
							.antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
							.anyRequest().authenticated())
	
		.formLogin(login -> login
				.loginPage("/login")			//따로 로그인페이지를 설정해준다.
				.usernameParameter("email")	//html input name을 따로 설정해준다.
				.defaultSuccessUrl("/homeTest")
				.permitAll()
				)
	
		.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/homeTest")
				.permitAll();
		
		return http.build();
	}
	
	/*@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("1234")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}*/
}
