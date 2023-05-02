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
	public List<ProductVO> selectAllList() {
		return productMapper.selectAllList();
	}
}
