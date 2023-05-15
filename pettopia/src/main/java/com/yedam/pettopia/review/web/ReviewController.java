package com.yedam.pettopia.review.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.pettopia.review.ReviewVO;
import com.yedam.pettopia.review.service.ReviewService;

@Controller
public class ReviewController {

@Autowired
ReviewService reviewService;

	//작성 가능한 후기 목록
	@GetMapping("reviewList")
	public String reviewList(Model model) {
		model.addAttribute("reviewList", reviewService.selectReviewList());
		return "review/reviewList";
	}
	
	//내가 작성한 후기 목록
	@GetMapping("writtenList")
	public String writtenList(Model model) {
		return "review/writtenList";
	}
	
	//후기 등록
	@PostMapping("reviewInsert")
	public String reviewInsert(ReviewVO reviewVO) {
		reviewService.insertReview(reviewVO);
		return "redirect:reviewList";
	}
	
}