package com.yedam.pettopia.product.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.pettopia.product.Product1VO;
import com.yedam.pettopia.product.service.ProductService1;
import com.yedam.pettopia.user.auth.PrincipalDetails;



@Controller



public class ProductCategoryController {
	
	@Autowired
	ProductService1 productService;
	
	@GetMapping("ProductCategory")
	public String ProductCategory(Model model){
		return"product/ProductCategory";
	}
	@GetMapping("ProductDetail")
	public String ProductDetail(Model model) {
		return "product/ProductDetail";
	}

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
		System.out.println("여기 출력 " + productService.selectPrdAllList());
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
