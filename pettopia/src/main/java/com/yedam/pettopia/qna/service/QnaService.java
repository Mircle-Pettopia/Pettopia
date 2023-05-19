package com.yedam.pettopia.qna.service;

import java.util.List;

import com.yedam.pettopia.qna.QnaVO;

public interface QnaService {
	
	//전체글조회
	public List<QnaVO> qnaAllList(String meId);
		
}
