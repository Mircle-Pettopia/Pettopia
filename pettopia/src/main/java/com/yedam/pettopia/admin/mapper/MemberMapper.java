package com.yedam.pettopia.admin.mapper;

import java.util.List;

import com.yedam.pettopia.admin.MemberVO;



public interface MemberMapper {
	
	// 회원 조회
	public List<MemberVO> selectMemberList();
	
	// 가입 경로 조회
	public List<MemberVO> selectPath();
	
	// 검색
	public List<MemberVO> searchList(MemberVO memberVO);
	
	
	
}
