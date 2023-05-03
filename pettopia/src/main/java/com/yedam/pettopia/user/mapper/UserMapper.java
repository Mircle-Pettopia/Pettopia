package com.yedam.pettopia.user.mapper;

import com.yedam.pettopia.user.UserVO;

public interface UserMapper {
	public UserVO getUserAccount(String meId);
	public int saveUser(UserVO vo);
	public int idChk(String meId);
	public UserVO findByKakaoId(Long meSnsToken);
}
