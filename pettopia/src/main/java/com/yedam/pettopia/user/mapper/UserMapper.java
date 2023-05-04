package com.yedam.pettopia.user.mapper;

import com.yedam.pettopia.user.UserVO;

public interface UserMapper {
	public UserVO getUserAccount(String meId);
	public int saveUser(UserVO vo);			//자사 회원가입
	public int kakaosaveUser(UserVO vo);	//카카오 획원가입
	public int idChk(String meId);
	public UserVO snsIdTokenChk(String meSnsToken);
	public UserVO snsIdToKenInfo(String meSnsToken);
}
