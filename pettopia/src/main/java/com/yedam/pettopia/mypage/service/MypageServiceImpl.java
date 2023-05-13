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
	public List<MypageVO> getOrder(String meId) {
		return mapper.getOrder(meId);
	}
	
	//전체 주문디테일 개수 들고온다
	@Override
	public int countOrderList() {
		return mapper.countOrderList();
	}
	//페이징기능
	@Override
	public List<MypageVO> pagingTest(MypageVO vo) {
		return mapper.pagingTest(vo);
	}
	
	
	@Override
	public MypageVO getOrdrList(String ordrId) {
		return mapper.getOrdrList(ordrId);
	}

	@Override
	public List<MypageVO> getOrderList(MypageVO vo) {
		return mapper.getOrderList(vo);
	}

	@Override
	public List<MypageVO> getPrcCount(String meId) {
		return mapper.getPrcCount(meId);
	}

	@Override
	public List<MypageVO> getShipCount(String meId) {
		return mapper.getShipCount(meId);
	}

	@Override
	public MypageVO ordtIdOptionInfo(String ordtId) {
		return mapper.ordtIdOptionInfo(ordtId);
	}

	@Override
	public List<MypageVO> ordrDetailList(String ordrId) {
		return mapper.ordrDetailList(ordrId);
	}


	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
