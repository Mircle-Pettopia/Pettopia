package com.yedam.pettopia.admin.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yedam.pettopia.admin.ProductVO;
import com.yedam.pettopia.admin.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("productMag")
	public String productMagForm(Model model) {
		model.addAttribute("prdAllCnt", productService.insertPrdCount());
		model.addAttribute("saleCnt", productService.salePrdCount());
		model.addAttribute("stopSaleCnt", productService.stopSalePrdCount());
		return "admin/productMag";
	}
	
	@GetMapping("productList")
	@ResponseBody
	public List<ProductVO> productList(){
		return productService.selectPrdAllList();
	}
	
	@PostMapping("insertPrd")
	@ResponseBody
	public String insertPrd(ProductVO vo) {
		productService.insertPrd(vo);
		return "success";
	}
	
	@GetMapping("productDetail")
	@ResponseBody
	public ProductVO productDetail() {
		ProductVO vo = new ProductVO();
		vo.setPrdtId("PRD1003");
		return productService.selectDetailList(vo);
	}
}
