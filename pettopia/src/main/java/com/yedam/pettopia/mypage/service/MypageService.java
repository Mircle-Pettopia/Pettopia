package com.yedam.pettopia.mypage.service;

import java.util.List;

import com.yedam.pettopia.mypage.MypageVO;

public interface MypageService {
	public MypageVO getOrder(String meId);
	public MypageVO getOrdrList(String ordrId);
	public List<MypageVO> getPrcCount(String meId);
	public List<MypageVO> getShipCount(String meId);
	public List<MypageVO> getOrderList(MypageVO vo);
	public MypageVO ordtIdOptionInfo(String ordtId);
	
	public int countOrderList();
	public List<MypageVO> pagingTest(MypageVO vo);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
