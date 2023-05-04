package com.yedam.pettopia.user.service;

import java.util.HashMap;

import com.yedam.pettopia.user.UserVO;

public interface UserService {
	public UserVO getUserAccount(String meId);
	public UserVO snsIdTokenChk(String meSnsToken);
	public UserVO snsIdToKenInfo(String meSnsToken);
	public int kakaosaveUser(UserVO vo);	//카카오 획원가입
	
	//kakao login
	public String getAccessToken(String authorize_code) throws Throwable;
	public HashMap<String, Object> getUserInfo(String access_Token) throws Throwable;
}
