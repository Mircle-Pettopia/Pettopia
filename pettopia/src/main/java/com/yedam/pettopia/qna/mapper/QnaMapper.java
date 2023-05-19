package com.yedam.pettopia.qna.mapper;

import java.util.List;

import com.yedam.pettopia.qna.QnaVO;

public interface QnaMapper {
	
	//전체글조회
	public List<QnaVO> qnaAllList(String meId);
	
}
