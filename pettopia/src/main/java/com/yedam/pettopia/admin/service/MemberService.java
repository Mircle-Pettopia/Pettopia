package com.yedam.pettopia.admin.service;

import java.util.List;
import com.yedam.pettopia.admin.MemberVO;



public interface MemberService {

	// 회원 조회
	public List<MemberVO> selectMemberList();
	
	// 검색
	public List<MemberVO> searchList(MemberVO memberVO);
	
}
