package com.yedam.pettopia.admin.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Map<String, Object> qnaAnswer(QnaMagVO vo) {
		qnaMagService.insertQnaReply(vo);
		
		Map<String, Object> map = new HashMap<>();
		map.put("answerList", qnaMagService.selectAnswerList(vo));
		map.put("qnaList", qnaMagService.selectQnaList(vo));
		map.put("cnt", qnaMagService.qstStCnt());
		return map;
	}
	
	// 내가 쓴 답글 조회
	@GetMapping("selectAnswer")
	@ResponseBody
	public List<QnaMagVO> selectAnswer(QnaMagVO vo){
		return qnaMagService.selectAnswerList(vo);
	}
	
	// 댓글 삭제
	@PostMapping("delComment")
	@ResponseBody
	public String deleteComment(QnaMagVO vo) {
		qnaMagService.deleteComment(vo);
		return "success";
	}
	
	// 댓글 수정
	@PostMapping("updComment")
	@ResponseBody
	public String updateComment(QnaMagVO vo) {
		qnaMagService.updateComment(vo);
		return "success";
	}
	
	// 검색
	@GetMapping("searchQna")
	@ResponseBody
	public List<QnaMagVO> searchQna(QnaMagVO vo){
		return qnaMagService.searchQnaList(vo);
	}
}
