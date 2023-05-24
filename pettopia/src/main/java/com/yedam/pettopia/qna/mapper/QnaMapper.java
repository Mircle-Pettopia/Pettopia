package com.yedam.pettopia.qna.mapper;

import java.util.List;

import com.yedam.pettopia.board.vo.BoardVO;
import com.yedam.pettopia.qna.QnaVO;

public interface QnaMapper {
	
	//전체글조회
	public List<QnaVO> qnaAllList(String meId);
	
	//전체글조회
	public List<QnaVO> qnaAllList2(String prdtId);
	
	//문의글등록
	public int insertQnA(QnaVO qnaVO);
	
	//단건조회
	public QnaVO QnaCheck(int qstNo);
	
	//문의댓글조회
	public List<QnaVO> QnaReply(int qstNo);
	
}
