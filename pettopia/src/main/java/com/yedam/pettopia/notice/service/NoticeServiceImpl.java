package com.yedam.pettopia.notice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.yedam.pettopia.notice.NoticeVO;
import com.yedam.pettopia.notice.mapper.NoticeMapper;

public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	NoticeMapper noticeMapper;

	@Override
	public List<NoticeVO> getNoticeList() {
		return noticeMapper.selectNoticeList();
	}

	@Override
	public int insertNotice(NoticeVO noticeVO) {
		return noticeMapper.insertNotice(noticeVO);
	}

}
