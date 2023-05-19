package com.yedam.pettopia.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.pettopia.admin.DashBoardVO;
import com.yedam.pettopia.admin.mapper.DashboardMapper;
import com.yedam.pettopia.admin.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	DashboardMapper dashboardMapper;

	@Override
	public List<DashBoardVO> saleChart(DashBoardVO vo) {
		// TODO Auto-generated method stub
		System.out.println(vo+"테스트");
		return dashboardMapper.saleChart(vo);
	}

	@Override
	public List<DashBoardVO> categoryChart() {
		// TODO Auto-generated method stub
		return dashboardMapper.categoryChart();
	}

	@Override
	public List<DashBoardVO> memberChart() {
		// TODO Auto-generated method stub
		return dashboardMapper.memberChart();
	}
	
}
