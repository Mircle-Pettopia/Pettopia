package com.yedam.pettopia.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.yedam.pettopia.user.UserVO;
import com.yedam.pettopia.user.mapper.UserMapper;

public class LoginIdPwValidator implements UserDetailsService{
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Autowired
    private UserMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String meId) throws UsernameNotFoundException {
		UserVO user =  mapper.getId(meId);
		
		if (user == null) {
            return null;
        }
		
		String pw = user.getPw(); 		//비밀빈호 암호화
        String roles = user.getRole(); //권한 = "USER"
        
        return User.builder()
                .username(meId)
                .password(pw)
                .roles(roles)
                .build();
	}

}
