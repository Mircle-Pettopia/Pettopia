package com.yedam.pettopia.product.service;

import java.util.List;

import com.yedam.pettopia.product.Product1VO;



public interface ProductService1 {

	// 상품 전체 조회
	public List<Product1VO> selectPrdAllList();
	
	// 상품 전체 조회
	public List<Product1VO> selectPrdAllList2();
	
	// 전체등록 상품 조회
	public int insertPrdCount();


}
