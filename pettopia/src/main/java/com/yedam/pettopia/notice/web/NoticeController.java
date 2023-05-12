package com.yedam.pettopia.notice.web;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yedam.pettopia.notice.Criteria;
import com.yedam.pettopia.notice.NoticeVO;
import com.yedam.pettopia.notice.PageVO;
import com.yedam.pettopia.notice.service.NoticeService;

@Controller
	public class NoticeController {
	
	@Autowired
	NoticeService noticeService;
	
		@GetMapping("noticeList")
		public String noticeList(Criteria cri, Model model) {
			model.addAttribute("noticeList", noticeService.NoticeListWithPaging(cri));
			int total= noticeService.totalCount(cri);
			model.addAttribute("pageMaker", new PageVO(cri, total));				
			return "notice/noticeList";
		}
		
		@GetMapping("noticeDetail")
		public String noticeDetail(NoticeVO noticeVO, Model model, @RequestParam final int noNo) {
			model.addAttribute("noticeDetail", noticeService.getNoticeDetail(noticeVO));
			int viewCnt = 0;		
			noticeService.viewCntUpdate(noNo);
			model.addAttribute("viewCnt",viewCnt);
			return "notice/noticeDetail";
		}
		
		@GetMapping("noticeInsertForm")
		public String noticeInsertForm(Model model) {
			model.addAttribute("noticeVO", new NoticeVO());
			return "notice/noticeInsert";
		}
		
		@PostMapping("noticeInsert")
		public String noticeInsert(NoticeVO noticeVO) {
			noticeService.insertNotice(noticeVO);
			return "redirect:noticeList";
		}
		
		@GetMapping("noticeUpdateForm")
		public String noticeUpdateForm(Model model, NoticeVO noticeVO ) {
			model.addAttribute("noticeDetail", noticeService.getNoticeDetail(noticeVO));
			return "notice/noticeUpdate";
		}
		
		@PostMapping("noticeUpdate")
		public String noticeUpdate(NoticeVO noticeVO) {
			noticeService.updateNotice(noticeVO);
			return "redirect:noticeList";
		}
		
		@GetMapping("noticeDelete")
	    private String noticeDelete(@RequestParam final int noNo) {
			noticeService.deleteNotice(noNo);
	        return "redirect:noticeList";
	    }
	}
