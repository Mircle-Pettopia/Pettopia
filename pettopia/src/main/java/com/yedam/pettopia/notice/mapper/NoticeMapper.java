package com.yedam.pettopia.notice.mapper;

import java.util.List;

import com.yedam.pettopia.notice.NoticeVO;

public interface NoticeMapper {

	//조회
	public List<NoticeVO> selectNoticeList();
	
	//등록
	public int insertNotice(NoticeVO noticeVO);
}
