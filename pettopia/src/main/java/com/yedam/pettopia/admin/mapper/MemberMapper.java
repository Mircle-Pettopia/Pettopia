package com.yedam.pettopia.admin.mapper;

import java.util.List;

import com.yedam.pettopia.admin.MemberVO;


public interface MemberMapper {
	
	// 회원 조회
	public List<MemberVO> selectMemberList();
	
	// 회원 상세 조회(모달)
	public List<MemberVO> detailMember (MemberVO memberVO);
	
	// 회원 수정
	public void updateMember(MemberVO memberVO);
	
}
