package com.yedam.pettopia.user.mapper;

import com.yedam.pettopia.user.UserVO;

public interface UserMapper {
	public UserVO getUserAccount(String meId);
	public int saveUser(UserVO vo);			//자사 회원가입
	public int kakaosaveUser(UserVO vo);	//카카오 획원가입
	public int idChk(String meId);			//아이디 체크
	public UserVO snsIdTokenChk(String meSnsToken);
	public UserVO snsIdToKenInfo(String meSnsToken);
	public UserVO snsGetNullInfo(String meSnsToken);	//sns로 회원가입 했을 때 주소, 폰번호가 없을 때 알림창 띄우기
	public int userInfoUpdate(UserVO vo);
	public int userDelete(String meId);
}
