package com.yedam.pettopia.product.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.pettopia.admin.ProductVO;
import com.yedam.pettopia.product.Product1VO;
import com.yedam.pettopia.product.mapper.ProductMapper1;
import com.yedam.pettopia.product.service.ProductService1;



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
	public List<Product1VO> selectPrdAllList2() {

		return productMapper.selectPrdAllList2();
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



}
