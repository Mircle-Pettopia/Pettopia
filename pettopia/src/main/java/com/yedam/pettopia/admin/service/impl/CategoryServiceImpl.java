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

	@Override
	public String getNewSCatID(CategoryVO vo) {
		categoryMapper.getNewSCatID(vo);
		System.out.println(vo.getSCatId()+"반환한 소분류 아이디");
		// TODO Auto-generated method stub
		return vo.getSCatId();
	}

	@Override
	public int DeleteLCat(List<String> lCatId) {
		// TODO Auto-generated method stub
		
		int result = 0;
		for(int i=0;i<lCatId.size();i++) {
			result+=categoryMapper.DeleteLCat(lCatId.get(i));
			result+=categoryMapper.DeleteLSCat(lCatId.get(i));
		}
		return result;
	}

	@Override
	public int DeleteSCat(List<String> sCatId) {
		// TODO Auto-generated method stub
		int result = 0;
		for(int i=0;i<sCatId.size();i++) {
			result+=categoryMapper.DeleteSCat(sCatId.get(i));
		}
		return result;
	}

	

}
