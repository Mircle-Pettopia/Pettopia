package com.yedam.pettopia.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.pettopia.admin.OrderVO;
import com.yedam.pettopia.admin.mapper.OrderMapper;
import com.yedam.pettopia.admin.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderMapper orderMapper;

	@Override
	public List<OrderVO> orderAllList() {
		return orderMapper.orderAllList();
	}

	@Override
	public int updatePrcSt(OrderVO vo) {
		return orderMapper.updatePrcSt(vo);
	}
}
