package com.yedam.pettopia.product.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import com.yedam.pettopia.admin.OptionDetailVO;
import com.yedam.pettopia.admin.ProductVO;

import com.yedam.pettopia.product.Product1VO;
import com.yedam.pettopia.review.ReviewVO;



public interface ProductMapper1 {
	
	// 상품 전체 조회 4개
	public List<Product1VO> selectPrdAllList();
	// 신상품 조회 4개 
	public List<Product1VO> selectPrdFList();
	
	// 상품 전체 조회
	public List<Product1VO> selectPrdAllList2(Product1VO product1VO);
	
	// 전체등록 상품 조회
	public int insertPrdCount();
	
	//카테고리 목록 가져오기
	public List<Product1VO> selectCategoryList();
	
	// 상품 단건 조회
	public Product1VO selectProductDetail(Product1VO product1VO);
	public Product1VO selectProdDetailList(String prdtId);
	
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
	 
	// 상품 후기 리스트
	public List<ReviewVO> selectWrittenList1(String prdtId);

	// 검색 조회
	public List<ProductVO> searchList1(ProductVO vo);

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
	}
