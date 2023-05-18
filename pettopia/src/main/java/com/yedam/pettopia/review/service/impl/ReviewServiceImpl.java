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
	
	//작성 가능한 후기 리스트
	@Override
	public List<ReviewVO> selectReviewList(String meId) {
		return reviewMapper.selectReviewList(meId);
	}

	//후기 등록
	@Override
	public int insertReview(ReviewVO reviewVO) {
		return reviewMapper.insertReview(reviewVO);
	}
	
	//내가 작성한 후기 리스트
	@Override
	public List<ReviewVO> selectWrittenList(String meId) {
		return reviewMapper.selectWrittenList(meId);
	}
	
	//후기 수정
	@Override
	public void updateReview(ReviewVO reviewVO) {
		reviewMapper.updateReview(reviewVO);
		
	}

	//후기 삭제
	@Override
	public void deleteReview(int reNo) {
		reviewMapper.deleteReview(reNo);
		
	}




}
