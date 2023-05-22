package com.yedam.pettopia;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.yedam.pettopia.user.auth.PrincipalOauth2UserService;
import com.yedam.pettopia.user.service.LoginSuccessHandler;
import com.yedam.pettopia.user.service.UserServiceImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	public final UserServiceImpl service;
	/* 로그인 실패 핸들러 의존성 주입 */
	private final AuthenticationFailureHandler CustomAuthFailureHandler;
	private final AuthenticationSuccessHandler LoginSuccessHandler;
	@Autowired private PrincipalOauth2UserService principalOauth2UserService;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
	 		.authorizeRequests()
				.antMatchers("/*","/download/*").permitAll()			//누구나 접근가능
				.antMatchers("/admin/**").hasAuthority("ROLE_ADMIN")	//admin만 접근가능
				//.antMatchers("/notice/**").hasAuthority("ROLE_ADMIN")
				.anyRequest().authenticated()							//나머지 요청들은 권한의 종류에 상관없이 권한이 있어야 접근가능
		.and()
			.formLogin()
					.loginPage("/login")						// GET 요청 (로그인페이지)
					//.loginProcessingUrl("/login_proc")		// POST 요청 (login 창에 입력한 데이터를 처리)
					.successHandler(LoginSuccessHandler)		// 로그인이 정상적으로 실행했을 때
					.failureHandler(CustomAuthFailureHandler) 	// 로그인 실패 핸들러
					.usernameParameter("meId")					// html input name을 따로 설정해준다.
					.passwordParameter("password")				// html input name을 따로 설정해준다.
					//.defaultSuccessUrl("/")					// 성공하면 쇼핑몰 메인페이지로 이동한다.
			.and()
				.logout()
				.logoutUrl("/logout")							// 로그아웃 페이지
				.logoutSuccessUrl("/")							// 로그아웃 성공시 리다이렉트 주소
				.invalidateHttpSession(true)					// 세션날리기
				.permitAll()
		.and()
			.oauth2Login()										// OAuth2기반의 로그인인 경우
					.loginPage("/login")						// 로그인페이지
					.defaultSuccessUrl("/")						// 로그인 성공하면 "/main" 으로 이동
					.failureUrl("/login")						// 로그인 실패 시 /loginForm으로 이동
					.userInfoEndpoint()							// 로그인 성공 후 사용자정보를 가져온다
					.userService(principalOauth2UserService);	// 사용자정보를 처리할 때 사용한다
		
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
                "/fonts/**",
                "/admin/assets/**"
                
                
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
