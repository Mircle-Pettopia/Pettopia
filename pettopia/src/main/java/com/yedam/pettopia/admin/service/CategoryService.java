package com.yedam.pettopia.admin.service;

import java.util.List;

import com.yedam.pettopia.admin.CategoryVO;

public interface CategoryService {
	public List<CategoryVO> selectL();
	public List<CategoryVO> selectS(String lcatId);
	public String getNewLCatID();
	public int VariableUpdates(CategoryVO vo);
}
