package com.yedam.pettopia.admin.mapper;

import java.util.List;

import com.yedam.pettopia.admin.QnaMagVO;

public interface QnaMagMapper {

	// qna 전체 조회
	public List<QnaMagVO> qnaAllList();

	// qna 답변 대기 카운트
	public int qstStCnt1();

	// qna 답변 완료 카운트
	public int qstStCnt2();
	
	// qna 답변 등록
	public int insertQnaReply(QnaMagVO vo);
}
