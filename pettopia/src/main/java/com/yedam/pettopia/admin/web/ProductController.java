package com.yedam.pettopia.admin.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.pettopia.admin.ProductVO;
import com.yedam.pettopia.admin.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/productMag")
	public String productMagForm() {
		return "admin/productMag";
	}
	
	@GetMapping("/testList")
	@ResponseBody
	public List<ProductVO> testList(){
		return productService.selectAllList();
	}
}
