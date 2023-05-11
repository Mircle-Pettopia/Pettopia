package com.yedam.pettopia.mypage.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.pettopia.common.service.CodeService;
import com.yedam.pettopia.mypage.MypageVO;
import com.yedam.pettopia.mypage.service.MypageService;
import com.yedam.pettopia.user.auth.PrincipalDetails;

@Controller
public class MypageController {
	@Autowired MypageService service;
	@Autowired CodeService codeService;
	
	//마이페이지-주문내역
	@GetMapping("mypage")
	public String orderList(Model model,
							@AuthenticationPrincipal PrincipalDetails principalDetails,
							Authentication authentication) {
		PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        String id = principal.getUser().getMeId();
        
    	model.addAttribute("id", principal.getUser().getMeId());
        model.addAttribute("name", principal.getUser().getName());
        model.addAttribute("code", codeService.getCodes("SS", "PS"));
        model.addAttribute("getprcSt", service.getPrcCount(id));
        model.addAttribute("getShipSt", service.getShipCount(id));
		return "mypage/mypage";
	}
	
	@GetMapping("getOrder")
	@ResponseBody
	public List<MypageVO> getOrder(@RequestParam String meId, @RequestParam(required = false) String start,
								@RequestParam(required = false) String end, @RequestParam(required = false) String shipSt,
								@RequestParam(required = false) String prcSt
								){
		MypageVO vo = new MypageVO();
		
		return service.getOrderList(meId, start, end, shipSt, prcSt);
	}
	
	//마이페이지-주문내역상세
	@GetMapping("orderListDtl")
	public String orderListDtl(Model model,
								@AuthenticationPrincipal PrincipalDetails principalDetails,
								Authentication authentication) {
		String result = "";
		//Object context = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	
		PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
        result += principal;
    	model.addAttribute("id", principal.getUser().getMeId());
        model.addAttribute("name", principal.getUser().getName());
        
		return "mypage/orderListDtl";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
