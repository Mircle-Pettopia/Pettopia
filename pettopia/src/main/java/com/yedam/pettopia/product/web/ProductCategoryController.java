package com.yedam.pettopia.product.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.pettopia.admin.ProductVO;
import com.yedam.pettopia.admin.service.ProductService;
import com.yedam.pettopia.product.Product1VO;
import com.yedam.pettopia.product.service.ProductService1;
import com.yedam.pettopia.qna.service.QnaService;
import com.yedam.pettopia.review.ReviewVO;
import com.yedam.pettopia.review.service.ReviewService;
import com.yedam.pettopia.user.auth.PrincipalDetails;

@Controller

public class ProductCategoryController {

	@Autowired
	ProductService1 productService;
	@Autowired
	ProductService productService1;
	@Autowired
	QnaService qnaService;
	@Autowired
	ReviewService reviewService;

	// 관심상품등록
	@PostMapping("InsertProduct")
	@ResponseBody
	public String InsertProduct(@RequestParam String prdtId, @RequestParam String meId) {

		productService.insertProduct(prdtId, meId);

		return "Data submitted successfully";
	}

	// 관심상품해제
	@GetMapping("deleteProduct")
	@ResponseBody
	public String deleteProduct(@RequestParam String prdtId, @RequestParam String meId) {
		productService.deleteProduct(prdtId, meId);
		return "Data deleted successfully";
	}

	// 장바구니등록

	/*
	  @PostMapping("addCart") public ResponseEntity<String> addCart(@RequestBody Map<String, Object> requestMap) {
		  String meId = (String)
	  requestMap.get("meId"); String prdtId = (String) requestMap.get("prdtId");
	  int cnt = Integer.parseInt((String) requestMap.get("cnt")); String optDetaIds
	  = (String) requestMap.get("optDetaIds");
	  
	   if (optDetaIds != null && !optDetaIds.isEmpty()) { 
	   int result = productService.addCart(requestMap);
	  
	  if (result > 0) { 
	  return ResponseEntity.ok().body("Success"); 
	  } 
	  else { 
	  return
	  ResponseEntity.badRequest().body("Failed");
	   } 
	   } else {
	  return ResponseEntity.badRequest().body("Failed: optDetaIds not provided"); } 
	   }
	   */
	
	
	 /*
	@PostMapping("addCart")
	public ResponseEntity<String> addCart(@RequestBody Map<String, Object> requestMap) {
		String meId = (String) requestMap.get("meId");
		String prdtId = (String) requestMap.get("prdtId");
		String cntValue = (String) requestMap.get("cnt");
		String optDetaIds = (String) requestMap.get("optDetaIds");
		System.out.println("addCart값" + meId + prdtId + cntValue + optDetaIds);

		// Check if cntValue is not null and can be parsed as an integer
		if (cntValue != null && !cntValue.isEmpty()) {
			try {
				int cnt = Integer.parseInt(cntValue);

				// Check if optDetaIds is empty or not provided
				if (optDetaIds != null) {
					// Perform necessary operations with the received data
					requestMap.put("cnt", cnt); // Update the "p_cnt" value in the requestMap
					int result = productService.addCart(requestMap);

					if (result > 0) {
						return ResponseEntity.ok().body("Success");
					} else {
						return ResponseEntity.badRequest().body("Failed");
					}
				} else {
					// Handle the case when optDetaIds is null
					// Your logic here
					return ResponseEntity.badRequest().body("Failed: optDetaIds is null");
				}
			} catch (NumberFormatException e) {
				// Handle the case when "p_cnt" is not a valid integer
				// Your logic here
				return ResponseEntity.badRequest().body("Failed: p_cnt is not a valid integer");
			}
		} else {
			// Handle the case when "p_cnt" is null or empty
			// Your logic here
			return ResponseEntity.badRequest().body("Failed: p_cnt is null or empty");
		}
	}
	*/
	//장바구니 등록
	@PostMapping("addCart")
	public ResponseEntity<String> addCart(@RequestBody Map<String, Object> requestMap) {
	    String meId = (String) requestMap.get("meId");
	    String prdtId = (String) requestMap.get("prdtId");
	    int cnt = Integer.parseInt((String) requestMap.get("cnt"));
	    Object optDetaIdsObj = requestMap.get("optDetaIds");


	    String optDetaIds = (optDetaIdsObj != null && !optDetaIdsObj.toString().isEmpty())
	            ? optDetaIdsObj.toString() : null;

	    requestMap.put("optDetaIds", optDetaIds);

	    int result = productService.addCart(requestMap);

	    if (result > 0) {
	        return ResponseEntity.ok().body("Success");
	    } else {
	        return ResponseEntity.badRequest().body("Failed");
	    }
	}







	// 카테고리 항목
	@GetMapping("ProductCategory")
	public String ProductCategory(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails,Product1VO product1VO,
			Authentication authentication) {
		String result = "";
		Object context = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (context != "anonymousUser") {
			PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
			if (principal.getUser().getSignPath() == "company") {
				result += principal;
				model.addAttribute("id", principal.getUser().getMeId());
				model.addAttribute("name", principal.getUser().getName());

				System.out.println(model);
			} else {
				result += principal;
				model.addAttribute("id", principal.getUser().getMeId());
				model.addAttribute("name", principal.getUser().getName());
				model.addAttribute("token", principal.getUser().getMeSnsToken());
			}
			;
		}
		;
		model.addAttribute("index", productService.selectPrdAllList2(product1VO));
		System.out.println("상태정보" + productService.selectPrdAllList2(product1VO));
		model.addAttribute("categories", productService.selectCategoryList());

		return "product/productCategory";
	}

	// 제품 상세조회
	@GetMapping("ProductDetail")
	public String ProductDetail(Product1VO product1VO,  Model model, @RequestParam final String prdtId,
			@AuthenticationPrincipal PrincipalDetails principalDetails, Authentication authentication) {
		System.out.println("상세조회 " + principalDetails);
		String result = "";
		model.addAttribute("qnaList", qnaService.qnaAllList2(prdtId));
		model.addAttribute("selectWritten1", productService.selectWrittenList1(prdtId));
		Object context = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (context != "anonymousUser") {
			PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
			if (principal.getUser().getSignPath() == "company") {
				result += principal;
				model.addAttribute("id", principal.getUser().getMeId());
				model.addAttribute("name", principal.getUser().getName());

				System.out.println(model);
			} else {
				result += principal;
				model.addAttribute("id", principal.getUser().getMeId());
				model.addAttribute("name", principal.getUser().getName());
				model.addAttribute("token", principal.getUser().getMeSnsToken());
				product1VO.setMeId(principal.getUser().getMeId());
				
			}
			;
		}
		;

		model.addAttribute("ProductDetail", productService.selectProductDetail(product1VO)); //상품디테일정보
		model.addAttribute("OptionList", productService.selectOption(prdtId));				
		model.addAttribute("optionDetailList", productService.selectOptionDetail(prdtId));
		model.addAttribute("productImg", productService.selectImg(product1VO));
		model.addAttribute("categories", productService.selectCategoryList());
		return "product/productDetail";
	}
	//검색
	@GetMapping("searchPrd1")
	@ResponseBody
	public List<ProductVO> searchPrd(ProductVO vo){
		return productService.searchList1(vo);
	}
	//메인페이지
	@GetMapping("/")
	public String productList(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails,
			Authentication authentication) {
		model.addAttribute("index", productService.selectPrdAllList());
		model.addAttribute("index2", productService.selectPrdFList());
		


		String result = "";
		Object context = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (context != "anonymousUser") {
			PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
			model.addAttribute("role", principal.getUser().getRole());

			if (principal.getUser().getSignPath() == "company") {
				result += principal;
				model.addAttribute("id", principal.getUser().getMeId());
				model.addAttribute("name", principal.getUser().getName());

				System.out.println(model);
			} else {
				result += principal;
				model.addAttribute("id", principal.getUser().getMeId());
				model.addAttribute("name", principal.getUser().getName());
				model.addAttribute("token", principal.getUser().getMeSnsToken());
			}
			;
		}
		;

		return "index";
	}

}
