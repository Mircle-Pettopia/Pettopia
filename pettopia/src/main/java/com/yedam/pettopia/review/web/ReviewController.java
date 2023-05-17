package com.yedam.pettopia.review.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.pettopia.notice.Criteria;
import com.yedam.pettopia.notice.PageVO;
import com.yedam.pettopia.review.ReviewVO;
import com.yedam.pettopia.review.service.ReviewService;
import com.yedam.pettopia.user.auth.PrincipalDetails;


@Controller
public class ReviewController {

@Autowired
ReviewService reviewService;

	//작성 가능한 후기 목록
	@GetMapping("reviewList")
	public String reviewList(Model model, @ModelAttribute("cri") Criteria cri, @AuthenticationPrincipal PrincipalDetails principal) {
		String id = principal.getUser().getMeId();
		model.addAttribute("reviewList", reviewService.selectReviewList(id, cri));
		int total = reviewService.totalCount(cri);
		PageVO pageVO = new PageVO(cri, total);
		model.addAttribute("pageMaker", pageVO);
		return "review/reviewList";
	}
	
	//내가 작성한 후기 목록
	@GetMapping("writtenList")
	public String writtenList(Model model) {
		model.addAttribute("writtenList", reviewService.selectWrittenList());
		return "review/writtenList";
	}
	
	//후기 등록
	@PostMapping("reviewInsert")
	@ResponseBody
	public String reviewInsert(ReviewVO reviewVO) {
		reviewService.insertReview(reviewVO);
		return "success";
	}
	
	
}