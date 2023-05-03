package com.yedam.pettopia.user.service;

import com.yedam.pettopia.user.UserVO;

public interface UserService {
	/*public UserVO loadUserByUsername(String meId);
	public void joinUser(UserVO vo);*/
	public UserVO getUserAccount(String meId);
	public String getAccessToken(String authorize_code);
}
