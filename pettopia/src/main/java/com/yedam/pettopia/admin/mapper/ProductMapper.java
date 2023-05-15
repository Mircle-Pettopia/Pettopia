package com.yedam.pettopia.admin.mapper;

import java.util.List;

import com.yedam.pettopia.admin.OptionDetailVO;
import com.yedam.pettopia.admin.OptionVO;
import com.yedam.pettopia.admin.ProductVO;

public interface ProductMapper {

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
	public ProductVO selectDetailList(String prdtId);

	// 이미지 등록
	public int insertImg(ProductVO vo);
	
	// 옵션 등록
	public int insertOption(OptionVO vo);
	
	// 옵션 디테일 등록
	public int insertOptionDetail(OptionDetailVO vo);
	
	// 상품 삭제
	public int deleteProduct(ProductVO vo);
	
	// 상품 이미지 삭제
	public int deletePrdImg(ProductVO vo);
	
	// 옵션 삭제
	public int deleteOption(String prdtId);
	
	// 옵션 디테일 삭제
	public int deleteOptionDetail(String prdtId);
	
	// 이미지 조회
	public List<ProductVO> selectImg(String prdtId);
	
	// 옵션 조회
	public List<OptionVO> selectOption(String prdtId);
	
	// 옵션 디테일 조회
	public List<OptionDetailVO> selectOptionDetail(String prdtId);
	
	// 검색 조회
	public List<ProductVO> searchList(ProductVO vo);
	
	// 상품 수정
	public int updatePrd(ProductVO vo);
	
}
