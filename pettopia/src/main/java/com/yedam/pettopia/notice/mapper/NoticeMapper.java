package com.yedam.pettopia.notice.mapper;

import java.util.List;

import com.yedam.pettopia.notice.NoticeVO;
import com.yedam.pettopia.notice.Criteria;

public interface NoticeMapper {

	//조회(페이징)
	public List<NoticeVO> NoticeListWithPaging(Criteria Cri);
	
	//전체 데이터 개수
	public int totalCount(Criteria Cri);
	
	//단건조회
	public NoticeVO selectNoticeDetail(NoticeVO noticeVO);	
	
	//등록
	public int insertNotice(NoticeVO noticeVO);
	
	//수정
	
	//삭제
	public void deleteNotice(int noNo);
	
}
