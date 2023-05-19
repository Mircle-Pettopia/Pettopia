package com.yedam.pettopia.qna.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.pettopia.qna.QnaVO;
import com.yedam.pettopia.qna.mapper.QnaMapper;
import com.yedam.pettopia.qna.service.QnaService;

@Service
public class QnaServiceImpl implements QnaService{
	@Autowired
	QnaMapper qnaMapper;
	
	
	@Override
	public List<QnaVO> qnaAllList(String meId) {

		return qnaMapper.qnaAllList(meId);
	}

}
