package com.yedam.pettopia.mypage.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.pettopia.admin.OptionVO;
import com.yedam.pettopia.common.service.CodeService;
import com.yedam.pettopia.mypage.MypageVO;
import com.yedam.pettopia.mypage.service.MypageService;
import com.yedam.pettopia.product.service.ProductService1;
import com.yedam.pettopia.user.auth.PrincipalDetails;

@Controller
public class MypageController {
	@Autowired MypageService service;
	@Autowired CodeService codeService;
	@Autowired ProductService1 productService;
	
	//마이페이지-주문내역
	@GetMapping("mypage")
	public String orderList(Model model,
							@AuthenticationPrincipal PrincipalDetails principal,
							MypageVO vo, String nowPage, String cntPerPage) {
        String id = principal.getUser().getMeId();
    	model.addAttribute("id", principal.getUser().getMeId());
        model.addAttribute("name", principal.getUser().getName());
        model.addAttribute("role", principal.getUser().getRole());
        model.addAttribute("code", codeService.getCodes("SS", "PS"));
        model.addAttribute("list",service.getOrder(id));
        model.addAttribute("getprcSt", service.getPrcCount(id));
        model.addAttribute("getShipSt", service.getShipCount(id));
        
        int total = service.countOrderList();
        cntPerPage = "8";
        //한 페이지 당 1~9개의 제품을 보이게 하는 곳
  		//cntPerPage = 제품별로 최대 나올 수 있는 값
        if (nowPage == null && cntPerPage == null) {
    		nowPage = "1";
    		cntPerPage = "8";
    	} else if (nowPage == null) {
    		nowPage = "1";
    	} else if (cntPerPage == null) { 
    		cntPerPage = "8";
    	}
        
        vo = new MypageVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
        model.addAttribute("paging", vo);
        
		return "mypage/mypage";
	};
	
	@GetMapping("option")
	@ResponseBody
	public MypageVO option(String ordtId){
		return service.ordtIdOptionInfo(ordtId);
	}
	
	//주문내역 검색기능
	@GetMapping("getOrder")
	@ResponseBody
	public List<MypageVO> getOrder(MypageVO vo){
		System.out.println("getOrder=======" + vo);
		return service.pagingTest(vo);
	}
	
	//마이페이지-주문내역상세
	@GetMapping("orderListDtl")
	public String orderListDtl(Model model,
							   @AuthenticationPrincipal PrincipalDetails principal,
							   @RequestParam String ordrId) {
		
    	model.addAttribute("id", principal.getUser().getMeId());
        model.addAttribute("name", principal.getUser().getName());
        model.addAttribute("role", principal.getUser().getRole());
        model.addAttribute("orderlist", service.getOrdrList(ordrId));
		return "mypage/orderListDtl";
	}
	
	@GetMapping("ordrDetailList")
	@ResponseBody
	public List<MypageVO> ordrDetailList(String ordrId) {
		return service.ordrDetailList(ordrId);
	}
	
	//마이페이지-관심상품조회
	@GetMapping("prodInterest")
	public String prodInterest(Model model,
							   @AuthenticationPrincipal PrincipalDetails principal,
							   String prdtId) {
		String id = principal.getUser().getMeId();
		//List<MypageVO> list = service.getInterestList(id); 
		//System.out.println("list>>>>>>>>>>>>>>>>" + list);
		//model.addAttribute("list", list);
		model.addAttribute("id", principal.getUser().getMeId());
        model.addAttribute("name", principal.getUser().getName());
        model.addAttribute("role", principal.getUser().getRole());
		return "mypage/prodInterest";
	}
	
	//마이페이지-관심상품리스트
	@GetMapping("prodInterestList")
	@ResponseBody
	public List<MypageVO> prodInterestList(@RequestParam String meId){
		return service.getInterestList(meId);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
