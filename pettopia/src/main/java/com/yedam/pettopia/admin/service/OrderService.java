package com.yedam.pettopia.admin.service;

import java.util.List;
import java.util.Map;

import com.yedam.pettopia.admin.OrderVO;

public interface OrderService {

	// 주문 전체조회
	public List<OrderVO> orderAllList();

	// 결제 상태 변경
	public int updatePrcSt(OrderVO vo);

	// 배송 상태 변경
	public int updateShipSt(OrderVO vo);

	// 운송장 등록
	public int updateInvo(OrderVO vo);

	// 결제 상태 카운트
	public Map<String, Integer> prcStCnt();

	// 주문 상품 조회
	public List<OrderVO> orderPrdList();

	// 검색
	public Map<String, List<OrderVO>> searchList(OrderVO vo);
	
	// 배송 상태 카운트
	public Map<String, Integer> shipStCnt();

}
