package com.yedam.pettopia.mypage.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.pettopia.board.service.BoardService;
import com.yedam.pettopia.board.vo.BoardVO;
import com.yedam.pettopia.cart.service.vo.CartListVO;
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
	@Autowired BoardService bservice;
	
	//마이페이지-주문내역
	@GetMapping("mypage")
	public String orderList(Model model,
							@AuthenticationPrincipal PrincipalDetails principal,
							MypageVO vo) {
        String id = principal.getUser().getMeId();
    	model.addAttribute("id", principal.getUser().getMeId());
        model.addAttribute("name", principal.getUser().getName());
        model.addAttribute("role", principal.getUser().getRole());
        model.addAttribute("code", codeService.getCodes("SS", "PS"));
        model.addAttribute("list",service.getOrder(id));
        model.addAttribute("getprcSt", service.getPrcCount(id));
        model.addAttribute("getShipSt", service.getShipCount(id));
		return "mypage/mypage";
	};
	
	@GetMapping("orderMaxPage")
	@ResponseBody
	public int orderMaxPage(String meId, String start, String end, String shipSt, String prcSt) {
		return service.orderMaxPage(meId, start, end, shipSt, prcSt);
	}
	
	@PostMapping("orderCancel")
	@ResponseBody
	public int orderCancel(String ordrId) {
		return service.orderCancel(ordrId);
	}
	
	@GetMapping("option")
	@ResponseBody
	public MypageVO option(String ordtId){
		return service.ordtIdOptionInfo(ordtId);
	}
	
	//주문내역 검색기능
	@GetMapping("getOrder")
	@ResponseBody
	public List<MypageVO> getOrder(String meId, String start, String end, String shipSt, String prcSt,
								   @RequestParam(defaultValue = "1", required = false) int page){
		System.out.println("getOrder=======" + page);
		return service.pagingTest(meId, start, end, shipSt, prcSt, page);
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
	
	//메인 - 본인 장바구니에 있는 상품의 개수 알려주기
	@GetMapping("interestCount")
	@ResponseBody
	public int interestCount(String meId) {
		return service.interestCnt(meId);
	}
	
	//interest list delete
	@PostMapping("interestDelete")
	@ResponseBody
	public int interestDelete(MypageVO vo) {
		System.out.println("vo>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + vo);
		
		String[] prdtId = vo.getPrdtId().split(",");
		
		System.out.println(prdtId[0] + "<<<<<<<<<<<<<<<<<<<<<<<<<");
		
		return service.interestDelete(vo, prdtId);
	}
	
	//cart + cart_detail INSERT ajax
	@PostMapping("intrestInCartInsert")
	@ResponseBody
	public int intrestInCartInesrt(@RequestBody CartListVO vo) {
		System.out.println(vo);
		int result = service.interstInCart(vo);
		return result;
	}
	
	//myboard page
	@GetMapping("mypost")
	public String mypost(Model model,
			   @AuthenticationPrincipal PrincipalDetails principal) {
		model.addAttribute("id", principal.getUser().getMeId());
		model.addAttribute("name", principal.getUser().getName());
		model.addAttribute("code", codeService.getCodes("BY"));
		return "mypage/mypost";
	}
	
	@GetMapping("mypostList")
	@ResponseBody
	public List<BoardVO> mypoastList(@RequestParam(defaultValue = "1", required = false) int page,
									String keyword, String meId, String boType){
		//model.addAttribute("Article",bservice.showKnowHow(boNo));
		return service.getBoardAllList(page, keyword, meId, boType);
	}
	
	@PostMapping("boardDetail")
	@ResponseBody
	public BoardVO boardDetail(@RequestParam int boNo) {
		return bservice.showKnowHow(boNo);
	}
	
	
	@GetMapping("boardAllMaxPage")
	@ResponseBody
	public int myKnowHowMaxPage(String keyword, String meId, String boType) {
		return service.boardAllMaxPage(keyword, meId, boType);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
