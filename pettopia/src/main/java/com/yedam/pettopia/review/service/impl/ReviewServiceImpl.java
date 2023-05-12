package com.yedam.pettopia.review.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.pettopia.review.ReviewVO;
import com.yedam.pettopia.review.mapper.ReviewMapper;
import com.yedam.pettopia.review.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewMapper reviewMapper;
	
	@Override
	public List<ReviewVO> selectReviewList() {
		return reviewMapper.selectReviewList();
	}

}
