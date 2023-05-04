package com.yedam.pettopia.board.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.pettopia.board.service.BoardService;
import com.yedam.pettopia.board.vo.BoardTestVO;
import com.yedam.pettopia.board.vo.BoardVO;

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
		model.addAttribute("Lists");
		return "board/knowHowList";
	}
	
	@PostMapping("insertKnowhow")
	@ResponseBody
	public int insertKnowhowArticle(BoardVO vo) {
		System.out.println(vo);
		return boardService.insertKnowhowArticle(vo);
	}
	
	@GetMapping("knowHowWriter")
	@ResponseBody
	public String knowHowWriter(Model model) {
		return "board/knowHowWriter";
	}
}
