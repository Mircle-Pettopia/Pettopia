package com.yedam.pettopia.user.mapper;

import java.util.List;

import com.yedam.pettopia.user.UserVO;

public interface UserMapper {
	List<UserVO> getUserList(); // User 테이블 가져오기
    void insertUser(UserVO userVo); // 회원 가입
    UserVO getUserByEmail(String email); // 회원 정보 가져오기
    UserVO getUserById(Long id);
	
}
