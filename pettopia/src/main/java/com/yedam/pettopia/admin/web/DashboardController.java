package com.yedam.pettopia.admin.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.pettopia.admin.DashBoardVO;
import com.yedam.pettopia.admin.service.DashboardService;

@Controller
@RequestMapping("/admin")
public class DashboardController {

	@Autowired
	DashboardService dashboardService;
	
	// 대시보드 페이지
	@GetMapping("dashboard")
	public String DashboardForm() {
		return "admin/dashboard";
	}
	
	@GetMapping("saleChart")
	@ResponseBody
	public List<DashBoardVO> saleChart(DashBoardVO vo){
		List<DashBoardVO> result = dashboardService.saleChart(vo);
		System.out.println(vo+"테스트테스트");
		System.out.println(result);
		return result;
	}
	
	@GetMapping("categoryChart")
	@ResponseBody
	public List<DashBoardVO> categoryChart(){
		List<DashBoardVO> result = dashboardService.categoryChart();
		return result;
	}
	
	@GetMapping("memberChart")
	@ResponseBody
	public List<DashBoardVO> memberChart(){
		List<DashBoardVO> result = dashboardService.memberChart();
		return result;
	}
	

}
