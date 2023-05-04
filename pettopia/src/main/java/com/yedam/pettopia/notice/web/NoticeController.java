package com.yedam.pettopia.notice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.pettopia.notice.NoticeVO;
import com.yedam.pettopia.notice.service.NoticeService;

@Controller
	public class NoticeController {
	
	@Autowired
	NoticeService noticeService;
	
	
		@GetMapping("noticeList")
		public String noticeList(Model model) {
			model.addAttribute("noticeList", noticeService.getNoticeList());
			return "notice/noticeList";
		}
		
		@GetMapping("noticeDetail")
		public String noticeDetail(NoticeVO noticeVO, Model model) {
			model.addAttribute("noticeDetail", noticeService.getNoticeDetail(noticeVO));
			return "notice/noticeDetail";
		}
		
		
		@GetMapping("noticeInsertForm")
		public String noticeInsertForm(Model model) {
			model.addAttribute("noticeVO", new NoticeVO());
			return "notice/noticeInsert";
		}
		
		@PostMapping("noticeInsert")
		public String noticeInsert(NoticeVO noticeVO) {
			System.out.println("여기 출력 " + noticeVO);
			noticeService.insertNotice(noticeVO);
			return "redirect:noticeList";
		}
		

	}
