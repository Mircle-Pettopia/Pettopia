package com.yedam.pettopia.review.mapper;

import java.util.List;

import com.yedam.pettopia.review.ReviewVO;

public interface ReviewMapper {
	
	//후기 작성 가능한 리스트
	public List<ReviewVO> selectReviewList();
	
}
