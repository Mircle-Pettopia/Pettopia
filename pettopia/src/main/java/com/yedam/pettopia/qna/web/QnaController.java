package com.yedam.pettopia.qna.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QnaController {
	@GetMapping("QnaList")
	public String QnaList(Model model) {
		return "qna/qna";
	}
	
	@GetMapping("QnaForm")
	public String QnaForm(Model model) {
		return "qna/qnaForm";
	}
	@GetMapping("QnaDetail")
	public String QnaDetail(Model model) {
		return "qna/qnaDetail";
	}
}
