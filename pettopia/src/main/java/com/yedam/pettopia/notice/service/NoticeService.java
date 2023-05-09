package com.yedam.pettopia.notice.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.yedam.pettopia.notice.Criteria;
import com.yedam.pettopia.notice.NoticeVO;

public interface NoticeService {
	//조회(페이징)
	public List<NoticeVO> NoticeListWithPaging(Criteria Cri);
	
	//전체 데이터 개수
	public int totalCount(Criteria Cri);
	
	//단건조회
	public NoticeVO getNoticeDetail(NoticeVO noticeVO);
	
	//등록
	public int insertNotice(NoticeVO noticeVO);
	
	//수정
	public void updateNotice(NoticeVO noticeVO);
	
	//삭제
	public void deleteNotice(int noNo);
	
	//조회수
	public void viewCntUpdate(int noNo);
}
