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


	@Override
	public int insertQna(QnaVO qnaVO) {
		return qnaMapper.insertQnA(qnaVO);
	}


	@Override
	public QnaVO QnaCheck(int qstNo) {

		return qnaMapper.QnaCheck(qstNo);
	}


	@Override
	public List<QnaVO> qnaAllList2(String prdtId) {

		return qnaMapper.qnaAllList2(prdtId);
	}

}
