package com.yedam.pettopia.admin.service;

import java.util.List;

import com.yedam.pettopia.admin.ProductVO;

public interface ProductService {

	// 상품 전체 조회
	public List<ProductVO> selectPrdAllList();

	// 전체등록 상품 조회
	public int insertPrdCount();

	// 판매중 상품 조회
	public int salePrdCount();

	// 판매중지 상품 조회
	public int stopSalePrdCount();

	// 상품 등록
	public int insertPrd(ProductVO vo);

	// 상품 상세 조회
	public ProductVO selectDetailList(ProductVO vo);
	
	// 이미지 등록
//	public int insertImg(ProductVO vo);

}
