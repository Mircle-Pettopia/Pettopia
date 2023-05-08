package com.yedam.pettopia.notice.service;

import java.util.List;


import com.yedam.pettopia.notice.NoticeVO;
import com.yedam.pettopia.notice.Criteria;

public interface NoticeService {
	//조회(페이징)
	public List<NoticeVO> NoticeListWithPaging(Criteria Cri);
	
	//전체 데이터 개수
	public int totalCount(Criteria Cri);
	
	//단건조회
	public NoticeVO getNoticeDetail(NoticeVO noticeVO);
	
	//등록
	public int insertNotice(NoticeVO noticeVO);
	
	//삭제
	public void deleteNotice(int noNo);
}
