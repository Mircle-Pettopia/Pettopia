package com.yedam.pettopia.notice.service;

import java.util.List;


import com.yedam.pettopia.notice.NoticeVO;

public interface NoticeService {
	//조회
	public List<NoticeVO> getNoticeList();
	
	//단건조회
	public NoticeVO getNoticeDetail(NoticeVO noticeVO);
	
	//등록
	public int insertNotice(NoticeVO noticeVO);
	
}
