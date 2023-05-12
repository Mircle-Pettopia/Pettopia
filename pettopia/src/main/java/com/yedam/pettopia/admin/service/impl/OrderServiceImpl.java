package com.yedam.pettopia.admin.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Override
	public int updateShipSt(OrderVO vo) {
		return orderMapper.updateShipSt(vo);
	}

	@Override
	public int updateInvo(OrderVO vo) {
		return orderMapper.updateInvo(vo);
	}

	@Override
	public Map<String, Integer> prcStCnt() {
		Map<String, Integer> map = new HashMap<>();
		map.put("prcSt1", orderMapper.prcStCnt1());
		map.put("prcSt2", orderMapper.prcStCnt2());
		map.put("prcSt3", orderMapper.prcStCnt3());
		return map;
	}

	@Override
	public List<OrderVO> orderPrdList() {
		return orderMapper.orderPrdList();
	}

	@Override
	public Map<String, List<OrderVO>> searchList(OrderVO vo) {
		Map<String, List<OrderVO>> map = new HashMap<>();
		map.put("orderList", orderMapper.searchList(vo));
		map.put("orderPrdList", orderMapper.searchPrdList(vo));
		return map;
	}
}
