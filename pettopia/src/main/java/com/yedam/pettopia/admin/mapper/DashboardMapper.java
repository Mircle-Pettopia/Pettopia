package com.yedam.pettopia.admin.mapper;

import java.util.List;

import com.yedam.pettopia.admin.DashBoardVO;

public interface DashboardMapper {
	public List<DashBoardVO> saleChart(DashBoardVO vo);
	public List<DashBoardVO> categoryChart();
	public List<DashBoardVO> memberChart();
}
