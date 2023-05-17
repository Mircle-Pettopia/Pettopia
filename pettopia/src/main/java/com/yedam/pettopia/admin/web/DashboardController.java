package com.yedam.pettopia.admin.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.pettopia.admin.service.DashboardService;

@Controller
public class DashboardController {

	@Autowired
	DashboardService dashboardService;
	
	// 대시보드 페이지
	@GetMapping("dashboard")
	public String DashboardForm() {
		return "admin/dashboard";
	}
}
