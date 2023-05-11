package com.yedam.pettopia.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.pettopia.admin.MemberVO;
import com.yedam.pettopia.admin.mapper.MemberMapper;
import com.yedam.pettopia.admin.service.MemberService;




@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;

	@Override
	public List<MemberVO> selectMemberList() {
		return memberMapper.selectMemberList();
	}

	@Override
	public List<MemberVO> searchList(MemberVO memberVO) {
		return memberMapper.searchList(memberVO);
		
	}





	
	
	
}
