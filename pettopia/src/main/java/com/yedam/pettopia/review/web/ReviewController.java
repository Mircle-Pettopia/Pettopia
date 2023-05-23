package com.yedam.pettopia.review.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.pettopia.review.ReviewVO;
import com.yedam.pettopia.review.service.ReviewService;
import com.yedam.pettopia.user.auth.PrincipalDetails;

@Controller
public class ReviewController {

@Autowired
ReviewService reviewService;

	//작성 가능한 후기 목록
	@GetMapping("reviewList")
	public String reviewList(Model model, @AuthenticationPrincipal PrincipalDetails principal) {
		String id = principal.getUser().getMeId();
		model.addAttribute("reviewList", reviewService.selectReviewList(id));
		return "review/reviewList";
	}
	
	//내가 작성한 후기 목록
	@GetMapping("writtenList")
	public String writtenList(Model model, @AuthenticationPrincipal PrincipalDetails principal) {
		String id = principal.getUser().getMeId();
		model.addAttribute("writtenList", reviewService.selectWrittenList(id));
		return "review/writtenList";
	}
	
	//후기 등록
	@PostMapping("reviewInsert")
	@ResponseBody
	public String reviewInsert(ReviewVO reviewVO) {
		reviewService.insertReview(reviewVO);
		return "success";
	}
	
	//후기 수정
	@PostMapping("reviewUpdate")
	@ResponseBody
	public String reviewUpdate(ReviewVO reviewVO) {
		reviewService.updateReview(reviewVO);
		return "success";
	}
	
	//후기 삭제
	@GetMapping("reviewDelete/{reNo}")
	private String reviewDelete(@PathVariable String reNo) {
	    int reviewNo = Integer.parseInt(reNo);
	    reviewService.deleteReview(reviewNo);
	    return "redirect:/writtenList";
	}
	
	//후기 상세
	@GetMapping("writtenDetail")
	@ResponseBody
	public ReviewVO writtenDetail(ReviewVO reviewVO){
		return reviewService.writtenDetail(reviewVO);
	}
	
	@GetMapping("optionDetail")
	@ResponseBody
	public ReviewVO option(String ordtId){
		return reviewService.optionDetail(ordtId);
	}
	
}