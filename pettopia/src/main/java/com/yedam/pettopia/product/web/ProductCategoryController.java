package com.yedam.pettopia.product.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.pettopia.product.Product1VO;
import com.yedam.pettopia.product.service.ProductService1;



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
	@GetMapping("/index")
	@ResponseBody
	public List<Product1VO> productList(){
		return productService.selectPrdAllList();
	}
	

}
