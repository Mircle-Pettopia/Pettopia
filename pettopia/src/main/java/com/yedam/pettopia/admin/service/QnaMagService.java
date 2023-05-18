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
}
