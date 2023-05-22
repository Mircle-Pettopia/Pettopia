package com.yedam.pettopia.admin.mapper;

import java.util.List;

import com.yedam.pettopia.admin.ReviewMagVO;

public interface ReviewMagMapper {

	public List<ReviewMagVO> reviewAllList();
	
	public List<ReviewMagVO> searchList(ReviewMagVO reviewMagVO);
	
	public ReviewMagVO reviewDetail(ReviewMagVO reviewMagVO);

	public int deleteReviewMag(ReviewMagVO reviewMagVO);
}
