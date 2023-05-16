package com.yedam.pettopia.admin.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.pettopia.admin.CategoryVO;
import com.yedam.pettopia.admin.service.CategoryService;

@Controller
public class CategoryController {
	@Autowired CategoryService categoryService;
	
	@GetMapping("categoryMag")
	public String categoryMan() {
		return "admin/categoryMag";
	}
	
	@GetMapping("getLCat")
	@ResponseBody
	public List<CategoryVO> getLCat(){
		return categoryService.selectL();
	}
	
	@GetMapping("getSCat")
	@ResponseBody
	public List<CategoryVO> getSCat(String lcatId){
		return categoryService.selectS(lcatId);
	}
	
	@GetMapping("getNewLCatID")
	@ResponseBody
	public String getNewLCatID() {
		String result= categoryService.getNewLCatID();
		System.out.println(result+"컨트롤러단");
		return result;
	}
	
	@PostMapping("VariableUpdates")
	@ResponseBody
	public int VariableUpdates(CategoryVO vo) {
		return categoryService.VariableUpdates(vo);
	}
}
