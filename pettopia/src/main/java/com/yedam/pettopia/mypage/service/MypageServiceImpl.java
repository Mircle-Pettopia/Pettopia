package com.yedam.pettopia.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.pettopia.mypage.MypageVO;
import com.yedam.pettopia.mypage.mapper.MypageMapper;

@Service
public class MypageServiceImpl implements MypageService{
	@Autowired MypageMapper mapper;

	@Override
	public List<MypageVO> getOrderList(String meId) {
		return mapper.getOrderList(meId);
	}

	@Override
	public String getOrderDetailCount(String prdtId) {
		return mapper.getOrderDetailCount(prdtId);
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
