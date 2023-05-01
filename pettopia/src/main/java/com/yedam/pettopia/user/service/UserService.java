package com.yedam.pettopia.user.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.yedam.pettopia.user.UserVO;
public interface UserService {
	
	public PasswordEncoder passwordEncoder();
	public UserVO getMeId(String email);
	public UserVO getMeId(Long id);
	public void signup(UserVO userVo);
	public List<UserVO> getUserList();
	UserVO getUserByEmail(String email);
	UserVO getUserById(Long id);

}
