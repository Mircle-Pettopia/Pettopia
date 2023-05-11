package com.yedam.pettopia.admin.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.pettopia.admin.OrderVO;
import com.yedam.pettopia.admin.service.OrderService;
import com.yedam.pettopia.common.service.CodeService;

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	CodeService codeService;
	
	// 주문 관리 페이지
	@GetMapping("orderMag")
	public String orderMagForm(Model model) {
		return "admin/orderMag";
	}
	
	// 주문 전체 조회
	@GetMapping("orderList")
	@ResponseBody
	public Map<String, Object> orderList(){
		Map<String, Object> map = new HashMap<>();
		map.put("orderList", orderService.orderAllList());
		map.put("code", codeService.getCodes("PS", "SS"));
		return map;
	}
	
	// 결제 상태 변경
	@PostMapping("updatePrcSt")
	@ResponseBody
	public String updatePrcSt(OrderVO vo) {
		orderService.updatePrcSt(vo);
		return "success";
	}
	

}
