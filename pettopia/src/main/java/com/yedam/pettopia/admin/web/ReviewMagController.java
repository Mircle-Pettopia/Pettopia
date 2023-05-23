package com.yedam.pettopia.admin.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import com.yedam.pettopia.admin.ReviewMagVO;
import com.yedam.pettopia.admin.service.ReviewMagService;

@Controller
public class ReviewMagController {
	@Autowired
	ReviewMagService reviewMagService;
	
	@GetMapping("reviewMag")
	public String reviewMag(Model model) {
		return "admin/reviewMag";
	}
	
	//후기 목록
	@GetMapping("reviewMagList")
	@ResponseBody
	public List<ReviewMagVO> reviewAllList(){
		return reviewMagService.reviewAllList();
	}
	
	//검색
	@GetMapping("searchrev")
	@ResponseBody
	public List<ReviewMagVO> searchrev(ReviewMagVO reviewMagVO){
		return reviewMagService.searchList(reviewMagVO);
	}
	
	//후기 상세
	@GetMapping("reviewDetail")
	@ResponseBody
	public ReviewMagVO reviewDetail(ReviewMagVO reviewMagVO){
		return reviewMagService.reviewDetail(reviewMagVO);
	}
	
	//삭제
	@PostMapping("reviewMagDelete")
	@ResponseBody
	public String reviewMagDelete(ReviewMagVO reviewMagVO) {
		reviewMagService.deleteReviewMag(reviewMagVO);
		return "success";
	}
	
}
