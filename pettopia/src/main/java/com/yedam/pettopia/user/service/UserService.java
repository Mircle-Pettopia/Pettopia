package com.yedam.pettopia.user.service;


import com.yedam.pettopia.user.UserVO;

public interface UserService {
	public UserVO getUserAccount(String meId);
	public UserVO snsIdTokenChk(String meSnsToken);
	public UserVO snsIdToKenInfo(String meSnsToken);
	public int kakaosaveUser(UserVO vo);			//카카오 획원가입
	public UserVO snsGetNullInfo(String meSnsToken);	//sns로 회원가입 했을 때 주소, 폰번호가 없을 때 알림창 띄우기
	public int userInfoUpdate(UserVO vo);
	public int userDelete(String meId);
	
	//kakao login
	//public String getAccessToken(String authorize_code) throws Throwable;
	//public HashMap<String, Object> getUserInfo(String access_Token) throws Throwable;
}
