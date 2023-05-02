package com.yedam.pettopia.product.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductCategoryController {
	@GetMapping("ProductCategory")
	public String ProductCategory(Model model){
		return"product/ProductCategory";
	}
	@GetMapping("ProductDetail")
	public String ProductDetail(Model model) {
		return "product/ProductDetail";
	}
	
	

}
