package com.yedam.pettopia.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.pettopia.admin.ReviewMagVO;
import com.yedam.pettopia.admin.mapper.ReviewMagMapper;
import com.yedam.pettopia.admin.service.ReviewMagService;

@Service
public class ReviewMagServiceImpl implements ReviewMagService {
	
	@Autowired
	ReviewMagMapper reviewMagMapper;

	@Override
	public List<ReviewMagVO> reviewAllList() {
		return reviewMagMapper.reviewAllList();
	}

	@Override
	public List<ReviewMagVO> searchList(ReviewMagVO reviewMagVO) {
		return reviewMagMapper.searchList(reviewMagVO);
	}

	@Override
	public ReviewMagVO reviewDetail(ReviewMagVO reviewMagVO) {
		return reviewMagMapper.reviewDetail(reviewMagVO);
	}

	@Override
	public int deleteReviewMag(ReviewMagVO reviewMagVO) {
		return reviewMagMapper.deleteReviewMag(reviewMagVO);
	}

	
	
	
}
