package com.yedam.pettopia.notice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.pettopia.common.FileUtil;
import com.yedam.pettopia.notice.Criteria;
import com.yedam.pettopia.notice.NoticeVO;
import com.yedam.pettopia.notice.mapper.NoticeMapper;
import com.yedam.pettopia.notice.service.NoticeService;

@Service
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	NoticeMapper noticeMapper;

	@Override
	//공지사항 목록 + 페이징
	public List<NoticeVO> NoticeListWithPaging(Criteria cri) {
		return noticeMapper.NoticeListWithPaging(cri);
	}

	@Override
	//전체 데이터 개수
	public int totalCount(Criteria Cri) {
		return noticeMapper.totalCount(Cri);
	}
	
	@Override
	//상세조회
	public NoticeVO getNoticeDetail(NoticeVO noticeVO) {
		return noticeMapper.selectNoticeDetail(noticeVO);
	}
	
	@Override
	public int insertNotice(NoticeVO noticeVO) {
		//첨부파일 처리
		if (noticeVO.getPartFile() != null) {
			String filename = FileUtil.fileupload(noticeVO.getPartFile());
			noticeVO.setFiles(filename);
		}
		
		return noticeMapper.insertNotice(noticeVO);
	}


	
	@Override
	//수정
	public void updateNotice(NoticeVO noticeVO) {
		noticeMapper.updateNotice(noticeVO);
	}

	@Override
	//삭제
	public void deleteNotice(int noNo) {
		noticeMapper.deleteNotice(noNo);
	}

	@Override
	//조회수
	public void viewCntUpdate(int noNo) {
		noticeMapper.viewCntUpdate(noNo);
		
	}

	@Override
	//파일 삭제
	public void fileDelete(NoticeVO noticeVO) {
		noticeMapper.fileDelete(noticeVO);
	}




}
