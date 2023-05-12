package com.yedam.pettopia.admin.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		model.addAttribute("count", orderService.prcStCnt());
		model.addAttribute("code", codeService.getCodes("PS", "SS"));
		return "admin/orderMag";
	}
	
	// 주문 전체 조회
	@GetMapping("orderList")
	@ResponseBody
	public Map<String, Object> orderList(){
		Map<String, Object> map = new HashMap<>();
		map.put("orderList", orderService.orderAllList());
		map.put("code", codeService.getCodes("PS", "SS"));
		map.put("orderPrdList", orderService.orderPrdList());
		return map;
	}
	
	// 결제 상태 변경
	@PostMapping("updatePrcSt")
	@ResponseBody
	public Map<String, Integer> updatePrcSt(OrderVO vo) {
		orderService.updatePrcSt(vo);
		return orderService.prcStCnt();
	}
	
	// 배송 상태 변경
	@PostMapping("updateShipSt")
	@ResponseBody
	public String updateShipSt(OrderVO vo) {
		orderService.updateShipSt(vo);
		return "success";
	}
	
	// 운송장 등록
	@PostMapping("insertInvo")
	@ResponseBody
	public List<OrderVO> insertInvo(@RequestBody OrderVO[] arr) {
		for(int i = 0; i < arr.length; i++) {
			orderService.updateInvo(arr[i]);
		}
		return orderService.orderAllList();
	}
	
	// 검색
	@GetMapping("searchOrder")
	@ResponseBody
	public Map<String, List<OrderVO>> searchOrder(OrderVO vo){
		System.out.println("출력 " + vo);
		return orderService.searchList(vo);
	}
	

}
