package com.yedam.pettopia.mypage.mapper;

import java.util.List;

import com.yedam.pettopia.mypage.MypageVO;

public interface MypageMapper {
	public MypageVO getOrder(String meId);
	public MypageVO getOrdrList(String ordrId);
	public List<MypageVO> getOrderList(MypageVO vo);
	public List<MypageVO> getPrcCount(String meId);
	public List<MypageVO> getShipCount(String meId);
	public MypageVO ordtIdOptionInfo(String ordtId);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
