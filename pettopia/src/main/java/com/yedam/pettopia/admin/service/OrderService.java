package com.yedam.pettopia.admin.service;

import java.util.List;

import com.yedam.pettopia.admin.OrderVO;

public interface OrderService {

	// 주문 전체조회
	public List<OrderVO> orderAllList();

	// 결제 상태 변경
	public int updatePrcSt(OrderVO vo);

}
