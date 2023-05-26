package com.yedam.pettopia.notice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.pettopia.notice.Criteria;
import com.yedam.pettopia.notice.NoticeVO;
import com.yedam.pettopia.notice.PageVO;
import com.yedam.pettopia.notice.service.NoticeService;

/*
 * 공지사항
 */
@Controller
public class NoticeController {

	@Autowired
	NoticeService noticeService;

	//공지사항 목록
	@GetMapping("noticeList")
	public String noticeList(@ModelAttribute("cri") Criteria cri, Model model) {
		model.addAttribute("noticeList", noticeService.NoticeListWithPaging(cri));
		int total = noticeService.totalCount(cri);
		PageVO pageVO = new PageVO(cri, total);
		model.addAttribute("pageMaker", pageVO);
		return "notice/noticeList";
	}
	//공지사항 상세조회
	@GetMapping("noticeDetail")
	public String noticeDetail(NoticeVO noticeVO, Model model) {
		model.addAttribute("noticeDetail", noticeService.getNoticeDetail(noticeVO));
		int viewCnt = 0;
		noticeService.viewCntUpdate(noticeVO.getNoNo());
		model.addAttribute("viewCnt", viewCnt);
		return "notice/noticeDetail";
	}
	//공지사항 등록 페이지
	@GetMapping("noticeInsertForm")
	public String noticeInsertForm(Model model) {
		model.addAttribute("noticeVO", new NoticeVO());
		return "notice/noticeInsert";
	}
	//공지사항 등록 처리
	@PostMapping("noticeInsert")
	public String noticeInsert(NoticeVO noticeVO) {
		noticeService.insertNotice(noticeVO);
		return "redirect:noticeList";
	}
	
	//공지사항 수정 페이지
	@GetMapping("noticeUpdateForm")
	public String noticeUpdateForm(Model model, NoticeVO noticeVO) {
		model.addAttribute("noticeDetail", noticeService.getNoticeDetail(noticeVO));
		return "notice/noticeUpdate";
	}
	//공지사항 수정 처리
	@PostMapping("noticeUpdate")
	public String noticeUpdate(NoticeVO noticeVO) {
	    noticeService.updateNotice(noticeVO);
	    return "redirect:/noticeDetail?noNo=" + noticeVO.getNoNo();
	}
	//공지사항 삭제 처리
	@GetMapping("noticeDelete/{noNo}")
	private String noticeDelete(@PathVariable String noNo) {
	    int noticeNo = Integer.parseInt(noNo);
	    noticeService.deleteNotice(noticeNo);
	    return "redirect:/noticeList";
	}
	
	//수정페이지 파일 삭제
	@PostMapping("filesDelete")
	@ResponseBody
	public String fileDelete(NoticeVO noticeVO) {
		  noticeService.fileDelete(noticeVO);
		  return "success";
	}
}
