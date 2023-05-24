package com.yedam.pettopia.mypage.service;

import java.util.List;

import com.yedam.pettopia.board.vo.BoardVO;
import com.yedam.pettopia.cart.service.vo.CartListVO;
import com.yedam.pettopia.mypage.MypageVO;

public interface MypageService {
	public List<MypageVO> getOrder(String meId);
	public MypageVO getOrdrList(String ordrId);
	public List<MypageVO> getPrcCount(String meId);
	public List<MypageVO> getShipCount(String meId);
	
	public List<MypageVO> getOrderList(MypageVO vo);
	public MypageVO ordtIdOptionInfo(String ordtId);
	
	public List<MypageVO> ordrDetailList(String ordrId);
	public List<MypageVO> getInterestList(String meId);
	
	public int interestCnt(String meId);
	public int orderCancel(String ordrId);
	
	public int countOrderList(String meId);
	public List<MypageVO> pagingTest(String meId, String start, String end, String shipSt, String prcSt, int page);
	public int orderMaxPage(String meId, String start, String end, String shipSt, String prcSt);
	
	public int interestDelete(MypageVO vo, String[] arr);
	
	//prodInterest -> cart insert
	public int interstInCart(CartListVO vo);
	
	//mypage_작성글조회
	public List<BoardVO> getBoardAllList(int page, String keyword, String meId, String boType);
	public int boardAllMaxPage(String keyword, String meId, String boType);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
