package com.yedam.pettopia.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.pettopia.admin.CategoryVO;
import com.yedam.pettopia.admin.mapper.CategoryMapper;
import com.yedam.pettopia.admin.service.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired CategoryMapper categoryMapper;
	@Override
	public List<CategoryVO> selectL() {
		// TODO Auto-generated method stub
		return categoryMapper.selectL();
	}

	@Override
	public List<CategoryVO> selectS(String lcatId) {
		// TODO Auto-generated method stub
		return categoryMapper.selectS(lcatId);
	}

	@Override
	public String getNewLCatID() {
		// TODO Auto-generated method stub
		CategoryVO vo = new CategoryVO();
		categoryMapper.getNewLCatID(vo);
		System.out.println(vo.getLCatId()+"IMPL단");
		return vo.getLCatId();
	}

	@Override
	public int VariableUpdates(CategoryVO vo) {
		// TODO Auto-generated method stub
		return categoryMapper.VariableUpdates(vo);
	}

	

}
