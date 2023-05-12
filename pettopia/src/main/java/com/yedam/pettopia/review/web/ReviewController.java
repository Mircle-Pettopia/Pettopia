package com.yedam.pettopia.review.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.pettopia.review.service.ReviewService;

@Controller
public class ReviewController {

@Autowired
ReviewService reviewService;

	@GetMapping("reviewList")
	public String reviewList(Model model) {
		model.addAttribute("reviewList", reviewService.selectReviewList());
		return "review/reviewList";
	}
}