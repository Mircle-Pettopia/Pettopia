package com.yedam.pettopia.product.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.pettopia.admin.ProductVO;
import com.yedam.pettopia.product.Product1VO;
import com.yedam.pettopia.product.mapper.ProductMapper1;
import com.yedam.pettopia.product.service.ProductService1;
import com.yedam.pettopia.review.ReviewVO;

@Service
public class ProductServiceImpl1 implements ProductService1{
	
	@Autowired
	ProductMapper1 productMapper;

	@Override
	public List<Product1VO> selectPrdAllList() {
		return productMapper.selectPrdAllList();
	}

	@Override
	public int insertPrdCount() {
		return productMapper.insertPrdCount();
	}

	@Override
	public List<Product1VO> selectPrdAllList2(Product1VO product1VO) {

		return productMapper.selectPrdAllList2(product1VO);
	}

	@Override
	public List<Product1VO> selectCategoryList() {

		return productMapper.selectCategoryList();
	}

	@Override
	public Product1VO selectProductDetail(Product1VO product1VO) {
		
		return productMapper.selectProductDetail(product1VO);
	}

	
	public Map<String, Object> selectProdDetailList(String prdtId) {
		Map<String, Object> map = new HashMap<>();
		Product1VO vo = productMapper.selectProdDetailList(prdtId);
		map.put("product", vo);
		//map.put("imgList", productMapper.selectImg(prdtId));
		//map.put("sCatList", productMapper.selectScate(vo));
		map.put("optionList", productMapper.selectOption(prdtId));
		//map.put("optionDetailList", productMapper.selectOptionDetail(prdtId));
		return map;
	}

	@Override
	public List<Product1VO> selectOption(String prdtId) {
		
		return productMapper.selectOption(prdtId);
	}

	@Override
	public List<Product1VO> selectOptionDetail(String prdtId) {
	
		return productMapper.selectOptionDetail(prdtId);
	}
	//관심상품등록
	@Override
	public void insertProduct(String prdtId, String meId) {
		
		 productMapper.insertProduct(prdtId, meId);
	}
	//관심상품해제
	@Override
	public void deleteProduct(String prdtId, String meId) {
		
		productMapper.deleteProduct(prdtId, meId);
	}
	//장바구니등록
	
	  @Override
	  @Transactional
	    public int addCart(Map<String, Object> requestMap) {
		  	requestMap.put("result",0);
	        productMapper.addCart(requestMap);
	        return ((BigDecimal) requestMap.get("result")).intValue();
	        
	    }

	@Override
	public List<Product1VO> selectPrdFList() {

		return productMapper.selectPrdFList();
	}

	@Override
	public List<ReviewVO> selectWrittenList1(String prdtId) {

		return productMapper.selectWrittenList1(prdtId);
	}

	@Override
	public List<ProductVO> searchList1(ProductVO vo) {

		return productMapper.searchList1(vo);
	}

	@Override
	public List<Product1VO> selectImg(Product1VO product1vo) {

		return productMapper.selectImg(product1vo);
	}

	@Override
	public List<ReviewVO> reviewList() {
		return productMapper.reviewList();
	}

	@Override
	public List<ReviewVO> popularItemList() {
		return productMapper.popularItemList();
	}

}
