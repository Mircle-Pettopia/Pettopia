package com.yedam.pettopia.admin.service;

import java.util.List;
import java.util.Map;

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

	// 판매 상태 조회
	public List<ProductVO> selectSaleSt();

	// 상품분류(대) 조회
	public List<ProductVO> selectLcate();

	// 상품분류(소) 조회
	public List<ProductVO> selectScate(ProductVO vo);

	// 상품 등록
	public int insertPrd(ProductVO vo);

	// 상품 상세 조회
	public Map<String, Object> selectDetailList(String prdtId);

	// 상품 삭제
	public int deleteProduct(ProductVO vo);

	// 검색 조회
	public List<ProductVO> searchList(ProductVO vo);
	
	// 상품 현황 조회
	public Map<String, Integer> currentPrd();

}
