package com.yedam.pettopia.admin.service;

import java.util.List;

import com.yedam.pettopia.admin.DashBoardVO;

public interface DashboardService {
	public List<DashBoardVO> saleChart(DashBoardVO vo);
	public List<DashBoardVO> categoryChart();
	public List<DashBoardVO> memberChart();
}
