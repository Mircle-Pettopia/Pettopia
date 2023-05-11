package com.yedam.pettopia.product.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.pettopia.admin.service.ProductService;
import com.yedam.pettopia.notice.NoticeVO;
import com.yedam.pettopia.product.Product1VO;
import com.yedam.pettopia.product.service.ProductService1;
import com.yedam.pettopia.user.auth.PrincipalDetails;



@Controller



public class ProductCategoryController {
	
	@Autowired
	ProductService1 productService;
	@Autowired
	ProductService productService1;
	
	
	//카테고리 항목
	@GetMapping("ProductCategory")
	public String ProductCategory(Model model){
		model.addAttribute("index", productService.selectPrdAllList2());
		model.addAttribute("categories", productService.selectCategoryList()); 
		return"product/ProductCategory";
	}
	
	//제품 상세조회
	@GetMapping("ProductDetail")
	public String ProductDetail(Product1VO product1VO, Model model, @RequestParam final String prdtId) {

		model.addAttribute("ProductDetail", productService.selectProductDetail(product1VO));
		System.out.println("옵션출력" + productService.selectOption(prdtId) );
		model.addAttribute("OptionList", productService.selectOption(prdtId));
		System.out.println("옵션디테일" + productService.selectOptionDetail(prdtId));
		model.addAttribute("optionDetailList", productService.selectOptionDetail(prdtId));
		return "product/ProductDetail";
	}
	

	/*
	 * @GetMapping("productDetail1")
	 * 
	 * @ResponseBody public Map<String, Object> productDetail(String prdtId) {
	 * return productService1.selectDetailList(prdtId); }
	 */
	

	

	/*
	 * @GetMapping("index")
	 * 
	 * @ResponseBody public List<Product1VO> productList(){ return
	 * productService.selectPrdAllList(); }
	 */
	@GetMapping("/")
	public String productList(Model model,
								@AuthenticationPrincipal PrincipalDetails principalDetails,
								Authentication authentication) {
		model.addAttribute("index", productService.selectPrdAllList());
		
		//======은애
		//Authentication 객체를 통해 유저 정보를 가져올 수 있다.
		String result = "";
		Object context = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		//System.out.println("어느소속이냐=====" + principal.getUser().getSignPath());
		
		//익명사용자도 페이지 접근이 가능하도록 진행하기
		//참고 : https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=phrack&logNo=80202619173
		if(context != "anonymousUser") {
			PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
			if(principal.getUser().getSignPath() == "company") {
				result += principal;
	            model.addAttribute("id", principal.getUser().getMeId());
	            model.addAttribute("name", principal.getUser().getName());
	            
	            System.out.println(model);
	        } else{
	        	result += principal;
	            model.addAttribute("id", principal.getUser().getMeId());
	            model.addAttribute("name", principal.getUser().getName());
	            model.addAttribute("token", principal.getUser().getMeSnsToken());
	        };
		};
	        
		return "index";
	}
	

}
