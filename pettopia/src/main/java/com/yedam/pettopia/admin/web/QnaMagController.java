package com.yedam.pettopia.admin.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.pettopia.admin.QnaMagVO;
import com.yedam.pettopia.admin.service.QnaMagService;
import com.yedam.pettopia.common.service.CodeService;

@Controller
public class QnaMagController {
	@Autowired
	QnaMagService qnaMagService;

	@Autowired
	CodeService codeService;
	// QnA 페이지
	@GetMapping("qnaMag")
	public String qnaPage(Model model) {
		model.addAttribute("code", codeService.getCodes("QS"));
		model.addAttribute("cnt", qnaMagService.qstStCnt());
		return "admin/qnaMag";
	}
	
	// QnA 전체 출력
	@GetMapping("qnaList")
	@ResponseBody
	public List<QnaMagVO> qnaAllList(){
		return qnaMagService.qnaAllList();
	}
	
	// QnA 답변 등록
	@PostMapping("qnaAnswer")
	@ResponseBody
	public String qnaAnswer(QnaMagVO vo) {
		System.out.println("여기 출력 " + vo);
		qnaMagService.insertQnaReply(vo);
		return "success";
	}
}
