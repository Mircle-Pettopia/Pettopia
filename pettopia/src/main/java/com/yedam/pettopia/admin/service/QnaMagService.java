package com.yedam.pettopia.admin.service;

import java.util.List;
import java.util.Map;

import com.yedam.pettopia.admin.QnaMagVO;

public interface QnaMagService {
	// qna 전체 조회
	public List<QnaMagVO> qnaAllList();

	// qna 답변 상태 카운트
	public Map<String, Integer> qstStCnt();

	// qna 답변 등록
	public int insertQnaReply(QnaMagVO vo);

	// 내가 쓴 답변 조회
	public List<QnaMagVO> selectAnswerList(QnaMagVO vo);

	// 단건 조회
	public QnaMagVO selectQnaList(QnaMagVO vo);

	// 댓글 삭제
	public int deleteComment(QnaMagVO vo);

	// 댓글 수정
	public int updateComment(QnaMagVO vo);

	// 검색
	public List<QnaMagVO> searchQnaList(QnaMagVO vo);
	
	// 상세 상품 이미지 조회
	public QnaMagVO detailImg(QnaMagVO vo);
}
