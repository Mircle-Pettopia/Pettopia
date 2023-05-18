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
	public List<DashBoardVO> saleChart() {
		// TODO Auto-generated method stub
		return dashboardMapper.saleChart();
	}
}
