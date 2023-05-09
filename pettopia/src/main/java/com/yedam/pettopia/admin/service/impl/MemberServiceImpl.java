package com.yedam.pettopia.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.pettopia.admin.mapper.MemberMapper;
import com.yedam.pettopia.admin.service.MemberService;
import com.yedam.pettopia.admin.web.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberMapper memberMapper;
	
	@Override
	public List<MemberVO> selectMemberList() {
		return memberMapper.selectMemberList();
	}

}
