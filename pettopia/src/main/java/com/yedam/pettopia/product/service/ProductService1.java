package com.yedam.pettopia.product.service;

import java.util.List;
import java.util.Map;

import com.yedam.pettopia.product.Product1VO;




public interface ProductService1 {

	// 상품 전체 조회
	public List<Product1VO> selectPrdAllList();
	
	// 상품 전체 조회
	public List<Product1VO> selectPrdAllList2();
	
	// 전체등록 상품 조회
	public int insertPrdCount();

	//카테고리 항목
	public List<Product1VO> selectCategoryList();
	
	// 상품 단건 조회
	public Product1VO selectProductDetail(Product1VO product1VO);
	/* public Map<String, Object> selectProdDetailList(String prdtId); */
	
	//상품옵션조회
	public List<Product1VO> selectOption(String prdtId);
	
	//옵션상세조회
	public List<Product1VO> selectOptionDetail(String prdtId);
	
	//관심상품등록
	public void insertProduct(String prdtId, String meId);
    //관심상품해제
	public void deleteProduct(String prdtId, String meId);
	
	//장바구니등록
	int addCart(Map<String, Object> requestMap);

}
