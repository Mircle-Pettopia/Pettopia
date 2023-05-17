package com.yedam.pettopia.review.mapper;

import java.util.List;

import com.yedam.pettopia.notice.Criteria;
import com.yedam.pettopia.review.ReviewVO;




public interface ReviewMapper {
	
	//후기 작성 가능한 리스트
	public List<ReviewVO> selectReviewList(String meId, Criteria Cri);
	
	//전체 데이터 개수
	public int totalCount(Criteria Cri);
	
	//후기 등록
	public int insertReview(ReviewVO reviewVO);
	
	//내가 작성한 리뷰 리스트
	public List<ReviewVO> selectWrittenList();
	
}
