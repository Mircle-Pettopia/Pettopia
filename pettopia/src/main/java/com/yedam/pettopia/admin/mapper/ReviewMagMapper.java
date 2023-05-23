package com.yedam.pettopia.admin.mapper;

import java.util.List;

import com.yedam.pettopia.admin.ReviewMagVO;

public interface ReviewMagMapper {

	public List<ReviewMagVO> reviewAllList();
	
	public List<ReviewMagVO> searchList(ReviewMagVO reviewMagVO);
	
	public ReviewMagVO reviewDetail(ReviewMagVO reviewMagVO);

	public int deleteReviewMag(ReviewMagVO reviewMagVO);

	// 답변 등록
	public int insertRevReply(ReviewMagVO vo);
	
	// 내가 쓴 답변 조회
	public List<ReviewMagVO> selectAnswerRevList(ReviewMagVO vo);
	
	// 단건 조회
	public ReviewMagVO selectRevList(ReviewMagVO vo);
	
	// 댓글 삭제
	public int deleteAnswerRev(ReviewMagVO vo);
	
	// 댓글 수정
	public int updateAnswerRev(ReviewMagVO vo);


}
