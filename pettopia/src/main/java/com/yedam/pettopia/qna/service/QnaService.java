package com.yedam.pettopia.qna.service;

import java.util.List;

import com.yedam.pettopia.qna.QnaVO;

public interface QnaService {
	
	//전체글조회
	public List<QnaVO> qnaAllList(String meId);
	
	//전체글조회
	public List<QnaVO> qnaAllList2(String prdtId);

	//문의글등록
	public int insertQna(QnaVO qnaVO);
	
	//단건조회
	public QnaVO QnaCheck(int qstNo);
}
