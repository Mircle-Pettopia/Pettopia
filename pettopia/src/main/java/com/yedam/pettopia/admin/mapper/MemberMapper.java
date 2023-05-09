package com.yedam.pettopia.admin.mapper;

import java.util.List;

import com.yedam.pettopia.admin.web.MemberVO;

public interface MemberMapper {
	
	// 회원 조회
	public List<MemberVO> selectMemberList();
	
}
