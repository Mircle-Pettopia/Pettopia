package com.yedam.pettopia.admin.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.pettopia.admin.ProductVO;
import com.yedam.pettopia.admin.service.ProductService;
import com.yedam.pettopia.common.service.CodeService;

@Controller
@RequestMapping("/admin")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CodeService codeService;
	
	// 상품 관리자 페이지
	@GetMapping("productMag")
	public String productMagForm(Model model) {
		model.addAttribute("prdAllCnt", productService.insertPrdCount());
		model.addAttribute("saleCnt", productService.salePrdCount());
		model.addAttribute("stopSaleCnt", productService.stopSalePrdCount());
		model.addAttribute("code", codeService.getCodes("ST"));		
		model.addAttribute("lCatList", productService.selectLcate());
		return "admin/productMag";
	}
	
	// 상품 리스트
	@GetMapping("productList")
	@ResponseBody
	public List<ProductVO> productList(){
		return productService.selectPrdAllList();
	}
	
	// 소분류리스트
	@GetMapping("sCatList")
	@ResponseBody
	public List<ProductVO> sCatList(ProductVO vo){
		return productService.selectScate(vo);
	}
	
	// 상품 등록
	@PostMapping("insertPrd")
	@ResponseBody
	public String insertPrd(ProductVO vo) {
		productService.insertPrd(vo);
		return "success";
	}
	
	// 상품 정보
	@GetMapping("productDetail")
	@ResponseBody
	public Map<String, Object> productDetail(String prdtId) {
		return productService.selectDetailList(prdtId);
	}
	
	// 상품 삭제
	@PostMapping("productDel")
	@ResponseBody
	public Map<String, Integer> productDelete(@RequestBody ProductVO[] arr) {
		if(arr != null) {
			for(int i = 0; i < arr.length; i++) {
				productService.deleteProduct(arr[i]);
			}
		}
		return productService.currentPrd();
	}
	
	// 검색
	@GetMapping("searchPrd")
	@ResponseBody
	public List<ProductVO> searchPrd(ProductVO vo){
		return productService.searchList(vo);
	}
	
	// 상품 수정
	@PostMapping("updatePrd")
	@ResponseBody
	public Map<String, Object> updatePrd(ProductVO vo){
		int result = productService.updatePrd(vo);
		Map<String, Object> map = new HashMap<>();
		if(result == 1) {
			map.put("currentPrd", productService.currentPrd());
			map.put("seletePrd", productService.selectPrdAllList());
		}else {
			map.put("error", null);
		}
		return map;
	}
	
}
