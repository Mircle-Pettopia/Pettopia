package com.yedam.pettopia.admin.mapper;

import java.util.List;

import com.yedam.pettopia.admin.OrderVO;

public interface OrderMapper {
	
	// 주문 전체조회
	public List<OrderVO> orderAllList();
	
	// 결제 상태 변경
	public int updatePrcSt(OrderVO vo);
	
	// 배송 상태 변경
	public int updateShipSt(OrderVO vo);
	
	// 운송장 등록
	public int updateInvo(OrderVO vo);
	
	// 결제 대기 카운트
	public int prcStCnt1();
	
	// 결제 완료 카운트
	public int prcStCnt2();
	
	// 결제 취소 카운트
	public int prcStCnt3();
	
	// 주문 상품 조회
	public List<OrderVO> orderPrdList();
	
	// 검색
	public List<OrderVO> searchList(OrderVO vo);
	
	// 검색 상품
	public List<OrderVO> searchPrdList(OrderVO vo);
}
