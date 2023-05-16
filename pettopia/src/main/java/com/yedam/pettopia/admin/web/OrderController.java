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
		model.addAttribute("prcSt", orderService.prcStCnt());
		model.addAttribute("shipSt", orderService.shipStCnt());
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
	public Map<String, Integer> updateShipSt(OrderVO vo) {
		orderService.updateShipSt(vo);
		return orderService.shipStCnt();
	}
	
	// 운송장 등록
	@PostMapping("insertInvo")
	@ResponseBody
	public Map<String, Object> insertInvo(@RequestBody OrderVO[] arr) {
		for(int i = 0; i < arr.length; i++) {
			orderService.updateInvo(arr[i]);
		}
		
		Map<String, Object> map = new HashMap<>();
		map.put("orderList", orderService.orderAllList());
		map.put("orderPrdList", orderService.orderPrdList());
		
		return map;
	}
	
	// 검색
	@GetMapping("searchOrder")
	@ResponseBody
	public Map<String, List<OrderVO>> searchOrder(OrderVO vo){
		return orderService.searchList(vo);
	}
	
	// 주문 디테일(상품)
	@GetMapping("orderDetailPrd")
	@ResponseBody
	public List<OrderVO> orderDetailPrd(OrderVO vo){
		return orderService.orderDetailList(vo);
	}
	
	// 주문 디테일(옵션)
	@GetMapping("orderDetailOption")
	@ResponseBody
	public OrderVO orderDetailOption(OrderVO vo){
		return orderService.orderDetailOption(vo);
	}
	

}
