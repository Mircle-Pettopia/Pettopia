package com.yedam.pettopia;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import com.yedam.pettopia.user.service.UserServiceImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	public final UserServiceImpl service;
	/* 로그인 실패 핸들러 의존성 주입 */
	private final AuthenticationFailureHandler CustomAuthFailureHandler;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
	 		.authorizeRequests()
				.antMatchers("/login","/","/signUp", "/**").permitAll()
				.antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")
				.anyRequest().authenticated()
		.and()
			.formLogin()
					.loginPage("/login")					// GET 요청 (로그인페이지)
					.loginProcessingUrl("/login_proc")		// POST 요청 (login 창에 입력한 데이터를 처리)
					.failureHandler(CustomAuthFailureHandler) 	// 로그인 실패 핸들러
					.usernameParameter("meId")				// html input name을 따로 설정해준다.
					.passwordParameter("password")
					.defaultSuccessUrl("/main")
		.and()
			.logout()
			.logoutUrl("/logout")
			.logoutSuccessUrl("/")
			.invalidateHttpSession(true)
			.permitAll()
		.and()
			.csrf().disable();
		
		return http.build();
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
	
	//static에 있는 파일을 읽어주는 곳
	@Bean
    public WebSecurityCustomizer configure() {
        return (web) -> web.ignoring().mvcMatchers(
                "/css/**",
                "/js/**",
                "/img/**",
                "/vendor/**",
                "/images/**",
                "/fonts/**"
                
        );
    }
	
	/*@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user@aaa.com")
				.password("1111")
				.roles("USER")
				.build();

		return new InMemoryUserDetailsManager(user);
	}*/
}
