package com.yedam.pettopia.product.mapper;

import java.util.List;

import com.yedam.pettopia.product.Product1VO;



public interface ProductMapper1 {
	
	// 상품 전체 조회 4개
	public List<Product1VO> selectPrdAllList();
	
	// 상품 전체 조회
	public List<Product1VO> selectPrdAllList2();
	
	// 전체등록 상품 조회
	public int insertPrdCount();
	
	//카테고리 목록 가져오기
	public List<Product1VO> selectCategoryList();
	
}
