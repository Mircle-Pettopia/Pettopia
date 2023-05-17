package com.yedam.pettopia.review.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.pettopia.notice.Criteria;
import com.yedam.pettopia.review.ReviewVO;
import com.yedam.pettopia.review.mapper.ReviewMapper;
import com.yedam.pettopia.review.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewMapper reviewMapper;
	
	//작성 가능한 후기 리스트
	@Override
	public List<ReviewVO> selectReviewList(String meId, Criteria Cri) {
		return reviewMapper.selectReviewList(meId, Cri);
	}
	
	@Override
	public int totalCount(Criteria Cri) {
		return reviewMapper.totalCount(Cri);
	}
	
	//후기 작성
	@Override
	public int insertReview(ReviewVO reviewVO) {
		return reviewMapper.insertReview(reviewVO);
	}
	
	//내가 작성한 후기 리스트
	@Override
	public List<ReviewVO> selectWrittenList() {
		return reviewMapper.selectWrittenList();
	}



}
