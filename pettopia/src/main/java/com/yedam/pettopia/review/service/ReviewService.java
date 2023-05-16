package com.yedam.pettopia.review.service;

import java.util.List;

import com.yedam.pettopia.review.ReviewVO;

public interface ReviewService {

	//후기 작성 가능한 리스트
	public List<ReviewVO> selectReviewList(String meId);
	
	//후기 등록
	public int insertReview(ReviewVO reviewVO);
	
	//내가 작성한 리뷰 리스트
	public List<ReviewVO> selectWrittenList();
}
