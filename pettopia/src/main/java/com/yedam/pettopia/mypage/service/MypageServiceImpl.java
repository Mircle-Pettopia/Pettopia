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
	public MypageVO getOrder(String meId) {
		return mapper.getOrder(meId);
	}

	@Override
	public List<MypageVO> getOrderList(String meId, String start, String end,
									String shipSt, String prcSt) {
		return mapper.getOrderList(meId, start, end, shipSt, prcSt);
	}

	@Override
	public List<MypageVO> getPrcCount(String meId) {
		return mapper.getPrcCount(meId);
	}

	@Override
	public List<MypageVO> getShipCount(String meId) {
		return mapper.getShipCount(meId);
	}

	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
