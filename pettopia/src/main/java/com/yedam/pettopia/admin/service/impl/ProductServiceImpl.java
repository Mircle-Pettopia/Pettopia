package com.yedam.pettopia.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.pettopia.admin.ProductVO;
import com.yedam.pettopia.admin.mapper.ProductMapper;
import com.yedam.pettopia.admin.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductMapper productMapper;

	@Override
	public List<ProductVO> selectPrdAllList() {
		return productMapper.selectPrdAllList();
	}

	@Override
	public int insertPrdCount() {
		return productMapper.insertPrdCount();
	}

	@Override
	public int salePrdCount() {
		return productMapper.salePrdCount();
	}

	@Override
	public int stopSalePrdCount() {
		return productMapper.stopSalePrdCount();
	}

	@Override
	public int insertPrd(ProductVO vo) {
		return productMapper.insertPrd(vo);
	}

	@Override
	public ProductVO selectDetailList(ProductVO vo) {
		return productMapper.selectDetailList(vo);
	}
}
