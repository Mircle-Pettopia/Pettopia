package com.yedam.pettopia.admin.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.pettopia.admin.ProductVO;
import com.yedam.pettopia.admin.service.ProductService;
import com.yedam.pettopia.common.service.CodeService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CodeService codeService;
	
	@GetMapping("productMag")
	public String productMagForm(Model model) {
		model.addAttribute("prdAllCnt", productService.insertPrdCount());
		model.addAttribute("saleCnt", productService.salePrdCount());
		model.addAttribute("stopSaleCnt", productService.stopSalePrdCount());
		model.addAttribute("code", codeService.getCodes("ST"));		
		model.addAttribute("lCatList", productService.selectLcate());
		return "admin/productMag";
	}
	
	@GetMapping("productList")
	@ResponseBody
	public List<ProductVO> productList(){
		return productService.selectPrdAllList();
	}
	
	@GetMapping("sCatList")
	@ResponseBody
	public List<ProductVO> sCatList(ProductVO vo){
		return productService.selectScate(vo);
	}
	
	@PostMapping("insertPrd")
	@ResponseBody
	public String insertPrd(ProductVO vo) {
		productService.insertPrd(vo);
		return "success";
	}
	
	@GetMapping("productDetail")
	@ResponseBody
	public Map<String, Object> productDetail(String prdtId) {
		return productService.selectDetailList(prdtId);
	}
	
	@PostMapping("productDel")
	@ResponseBody
	public String productDelete(@RequestBody ProductVO[] arr) {
		if(arr != null) {
			for(int i = 0; i < arr.length; i++) {
				productService.deleteProduct(arr[i]);
			}
		}
		return "success";
	}
}
