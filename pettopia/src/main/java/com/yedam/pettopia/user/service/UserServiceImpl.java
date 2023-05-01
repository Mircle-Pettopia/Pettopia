package com.yedam.pettopia.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.yedam.pettopia.user.UserVO;
import com.yedam.pettopia.user.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
    private UserMapper mapper;
	private PasswordEncoder passwordEncoder;

	@Override
	public PasswordEncoder passwordEncoder() {
		return this.passwordEncoder;
	}

	@Override
	public UserVO getUserByEmail(String email) {
		return mapper.getUserByEmail(email);
	}

	@Override
	public UserVO getUserById(Long id) {
		return mapper.getUserById(id);
	}

	@Override
	public void signup(UserVO userVo) {
		 if (!userVo.getName().equals("") && !userVo.getMeId().equals("")) {
			    // password는 암호화해서 DB에 저장           
	            userVo.setPw(passwordEncoder.encode(userVo.getPw()));
	            mapper.insertUser(userVo);
	        }
	}

	//어드민 회원관리 ??
	@Override
	public List<UserVO> getUserList() {
		return mapper.getUserList();
	}

	@Override
	public UserVO getMeId(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserVO getMeId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


}
