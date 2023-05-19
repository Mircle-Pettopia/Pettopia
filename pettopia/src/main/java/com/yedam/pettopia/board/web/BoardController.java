package com.yedam.pettopia.board.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.pettopia.board.service.BoardService;
import com.yedam.pettopia.board.vo.BoardTestVO;
import com.yedam.pettopia.board.vo.BoardVO;
import com.yedam.pettopia.common.service.CodeService;
import com.yedam.pettopia.user.auth.PrincipalDetails;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BoardController {
	@Autowired BoardService boardService;
	@Autowired CodeService codeService;
	
	//======================테스트파트=============
	@GetMapping("editor")
	public String editor(Model model) {
		return "board/boardEditorTest";
	}
	@GetMapping("viewer")
	public String viewer(Model model) {
		return "board/boardViewerTest";
	}
	@PostMapping("insert")
	@ResponseBody
	public int insertArticle(BoardTestVO vo) {
		System.out.println(vo);
		return boardService.insertArticle(vo);
	}
	@PostMapping("show")
	@ResponseBody
	public BoardTestVO showArticle(String no) {
		System.out.println(boardService.showArticle(no));
		return boardService.showArticle(no);
	}
	//======================테스트파트끝================
	@GetMapping("knowhow")
	public String knowhow(Model model) {
		
		return "board/knowHowList";
	}
	
	@GetMapping("knowhowList")
	@ResponseBody
	public List<BoardVO> knowhowList(@RequestParam(defaultValue = "1", required = false) int page,
			                         String keyword) {
		
		return boardService.knowHowList(page,keyword);
	}
	
	@PostMapping("insertKnowhow")
	@ResponseBody
	public int insertKnowhowArticle(BoardVO vo) {
		System.out.println(vo);
		return boardService.insertKnowhowArticle(vo);
	}
	
	@GetMapping("knowHowMaxPage")
	@ResponseBody
	public int knowHowMaxPage(String keyword) {
		return boardService.knowHowMaxPage(keyword);
	}
	
	@GetMapping("knowHowWriter")
	public String knowHowWriter() {
		return "board/knowHowWriter";
	}
	
	@GetMapping("showKnowHow")
	public String showKnowHow(Model model,@RequestParam("boNo") int boNo) {
		model.addAttribute("Article",boardService.showKnowHow(boNo));
		return "board/knowHowArticle";	
	}
	
	//글 수정페이지 열기
	@GetMapping("modKnowHow")
	public String modKnowHow(Model model,@RequestParam("boNo") int boNo) {
		model.addAttribute("Article",boardService.showKnowHow(boNo));
		return "board/knowHowMod";	
	}
	
	@GetMapping("getknowHowReply")
	@ResponseBody
	public List<BoardVO> getknowHowReply(Model model,@RequestParam("boNo") int boNo) {
		return boardService.getknowHowReply(boNo);	
	}
	
	@PostMapping("insertKnowHowReply")
	@ResponseBody
	public int insertKnowHowReply(BoardVO vo) {
		System.out.println(vo);
		return boardService.insertKnowHowReply(vo);
	}
	
	@GetMapping("getUser")
	@ResponseBody
	public String getUser(@AuthenticationPrincipal PrincipalDetails principal) {
		
		return principal.getUser().getMeId();
	}
	
	@GetMapping("knowHowAddHit")
	@ResponseBody
	public void knowHowAddHit(int boNo) {
		boardService.KnowHowAddhit(boNo);
	}
	
	@DeleteMapping("delKnowHow")
	@ResponseBody
	public int delKnowHow(int boNo,String Uid) {
		return boardService.delKnowHow(boNo, Uid);
	}
	//글수정 업데이트
	@PostMapping("updateKnowHow")
	@ResponseBody
	public int updateKnowHow(BoardVO vo) {
		return boardService.updateKnowHow(vo);
	}
	@DeleteMapping("delKnowHowReply")
	@ResponseBody
	public int delKnowHowReply(int commentId) {
		return boardService.delKnowHowReply(commentId);
	}
	
	//---------------------------------------------------
	//분양게시판페이지
	@GetMapping("adopt")
	public String adopt(Model model, @AuthenticationPrincipal PrincipalDetails principal) {
		model.addAttribute("id", principal.getUser().getMeId());
		model.addAttribute("code", codeService.getCodes("BA", "SX", "AS", "BS", "AA"));
		return "Board/adopt";
	};
	
	@PostMapping("adoptList")
	@ResponseBody
	public List<BoardVO> adoptList(BoardVO vo){
		return boardService.adoptAllList(vo);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
