package com.yedam.pettopia.board.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.pettopia.board.service.BoardService;
import com.yedam.pettopia.board.vo.BoardTestVO;
import com.yedam.pettopia.board.vo.BoardVO;
import com.yedam.pettopia.user.auth.PrincipalDetails;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BoardController {
	@Autowired
	BoardService boardService;
	
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
	public List<BoardVO> knowhowList(int page,String keyword) {
		if(page==0) {
		page=1;
		}
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
	public String getUser(@AuthenticationPrincipal PrincipalDetails principalDetails,Authentication authentication) {
		PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
		return principal.getUser().getMeId();
	}
	
	@GetMapping("knowHowAddHit")
	@ResponseBody
	public void knowHowAddHit(int boNo) {
		boardService.KnowHowAddhit(boNo);
	}
}
