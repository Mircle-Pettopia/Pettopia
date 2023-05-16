package com.yedam.pettopia.mypage.mapper;

import java.util.List;

import com.yedam.pettopia.mypage.MypageVO;

public interface MypageMapper {
	//public MypageVO getOrder(String meId);
	public List<MypageVO> getOrder(String meId);
	public MypageVO getOrdrList(String ordrId);
	public List<MypageVO> getOrderList(MypageVO vo);
	public List<MypageVO> getPrcCount(String meId);
	public List<MypageVO> getShipCount(String meId);
	public MypageVO ordtIdOptionInfo(String ordtId);
	
	//주문내역디테일조회
	public List<MypageVO> ordrDetailList(String ordrId);
	//관심상품조회
	public List<MypageVO> getInterestList(String meId);
	//관심상품 개수
	public int interestCnt(String meId);
	
	//페이징
	public int countOrderList();
	public List<MypageVO> pagingTest(MypageVO vo);
	
	//관심상품 삭제
	public int interestDelete(MypageVO vo);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
