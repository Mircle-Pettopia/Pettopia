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
	
	// 내가 쓴 답변 조회
	public List<QnaMagVO> selectAnswerList(QnaMagVO vo);
	
	// 답변 등록 하면 답변 상태 변경
	public int updateQstSt(QnaMagVO vo);
	
	// 단건 조회
	public QnaMagVO selectQnaList(QnaMagVO vo);
	
	// 댓글 삭제
	public int deleteComment(QnaMagVO vo);
	
	// 댓글 수정
	public int updateComment(QnaMagVO vo);
	
	// 검색
	public List<QnaMagVO> searchQnaList(QnaMagVO vo);
}
