package com.yedam.pettopia.notice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.pettopia.notice.NoticeVO;
import com.yedam.pettopia.notice.Criteria;
import com.yedam.pettopia.notice.mapper.NoticeMapper;
import com.yedam.pettopia.notice.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	NoticeMapper noticeMapper;

	@Override
	public List<NoticeVO> NoticeListWithPaging(Criteria cri) {
		return noticeMapper.NoticeListWithPaging(cri);
	}

	@Override
	public NoticeVO getNoticeDetail(NoticeVO noticeVO) {
		return noticeMapper.selectNoticeDetail(noticeVO);
	}
	
	@Override
	public int insertNotice(NoticeVO noticeVO) {
		return noticeMapper.insertNotice(noticeVO);
	}

	@Override
	public int totalCount(Criteria Cri) {
		return noticeMapper.totalCount(Cri);
	}

	@Override
	public void deleteNotice(int noNo) {
		noticeMapper.deleteNotice(noNo);
		
	}


}
