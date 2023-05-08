package com.yedam.pettopia.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
