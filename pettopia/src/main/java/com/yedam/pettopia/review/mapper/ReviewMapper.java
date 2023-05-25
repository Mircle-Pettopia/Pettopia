package com.yedam.pettopia.review.mapper;

import java.util.List;


import com.yedam.pettopia.review.ReviewVO;

public interface ReviewMapper {

	// 후기 작성 가능한 리스트
	public List<ReviewVO> selectReviewList(String meId);
	
	// 후기 등록
	public int insertReview(ReviewVO reviewVO);

	// 내가 작성한 후기 리스트
	public List<ReviewVO> selectWrittenList(String meId);
	
	//후기 수정
	public void updateReview(ReviewVO reviewVO);
	
	//후기 삭제
	public void deleteReview(int reNo);
	
	//작성 후기 디테일
	public ReviewVO writtenDetail(ReviewVO reviewVO);

	public ReviewVO ordtIdOptionInfo(String ordtId);
}
