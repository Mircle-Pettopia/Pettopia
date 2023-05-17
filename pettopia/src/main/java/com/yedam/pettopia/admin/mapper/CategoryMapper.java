package com.yedam.pettopia.admin.mapper;

import java.util.List;

import com.yedam.pettopia.admin.CategoryVO;

public interface CategoryMapper {
	public List<CategoryVO> selectL();
	public List<CategoryVO> selectS(String lcatId);
	public void getNewLCatID(CategoryVO vo);
	public int VariableUpdates(CategoryVO vo);
	public void getNewSCatID(CategoryVO vo);
	public int DeleteLCat(String lCatId);
	public int DeleteLSCat(String lCatId);
	public int DeleteSCat(String lCatId);
}
