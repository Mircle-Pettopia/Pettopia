package com.yedam.pettopia.notice.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.pettopia.notice.NoticeVO;

@Controller
	public class NoticeController {
	
	
	
		@GetMapping("noticeList")
		public String noticeList(Model model) {
			return "notice/noticeList";
		}
		
		
		@GetMapping("noticeInsert")
		public String noticeInsertForm(Model model) {
			model.addAttribute("noticeVO", new NoticeVO());
			return "noticeInsert";
		}
		

	}
