package com.yedam.pettopia.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.pettopia.admin.mapper.DashboardMapper;
import com.yedam.pettopia.admin.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	DashboardMapper dashboardMapper;
}
