package com.yedam.pettopia.mypage.service;

import java.util.List;

import com.yedam.pettopia.mypage.MypageVO;

public interface MypageService {
	public MypageVO getOrder(String meId);
	public List<MypageVO> getOrderList(String meId, String start, String end,
			String shipSt, String prcSt);
	public List<MypageVO> getPrcCount(String meId);
	public List<MypageVO> getShipCount(String meId);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
