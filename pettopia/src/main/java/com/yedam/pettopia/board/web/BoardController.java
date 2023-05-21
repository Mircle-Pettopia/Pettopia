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
	@GetMapping("ageComp")
	public String ageComp() {
		return "fun/ageComp";	
	}
	
	
	//---------------------------------------------------
	//분양게시판 페이지
	@GetMapping("adopt")
	public String adopt(Model model, @AuthenticationPrincipal PrincipalDetails principal) {
		//model.addAttribute("id", principal.getUser().getMeId());
		model.addAttribute("code", codeService.getCodes("DG", "CT", "SX", "AS", "BA", "AA"));
		//												멍품종  냥품종   성별  분양상태  동물   지역
		return "board/adopt";
	};
	
	//분양게시판 전체목록
	@PostMapping("adoptList")
	@ResponseBody
	public List<BoardVO> adoptList(@RequestParam(defaultValue = "1", required = false) int page,
								   @RequestParam(required=false) String petType,
								   @RequestParam(required=false) String breed,
								   @RequestParam(required=false) String sex,
								   @RequestParam(required=false) String city){
		
		System.out.println(page +  petType +  breed +  sex +  city);
		return boardService.adoptAllList(page, petType, breed, sex, city);
	};
	
	@GetMapping("adoptMaxPage")
	@ResponseBody
	public int adoptCount(@RequestParam(required=false) String petType,
						  @RequestParam(required=false) String breed,
					      @RequestParam(required=false) String sex,
						  @RequestParam(required=false) String city) {
		return boardService.adoptMaxPage(petType, breed, sex, city);
	};
	
	//분양게시판 글등록 페이지
	@GetMapping("adoptWriter")
	public String adoptWriter(Model model, @AuthenticationPrincipal PrincipalDetails principal) {
		model.addAttribute("code", codeService.getCodes("DG", "CT", "SX", "AS", "BA", "AA", "YN"));
		//												멍품종  냥품종   성별  분양상태  동물   지역  중성화여부
		model.addAttribute("id", principal.getUser().getMeId());
		return "board/adoptWriter";
	}
	
	
	//분양게시판 글등록
	@PostMapping("insertAdopt")
	@ResponseBody
	public int insertAdopt(BoardVO vo) {
		return boardService.insertAdoptArticle(vo);
	}
	
	//분양게시판 단건조회
	@GetMapping("adoptAticle")
	public String adoptDetail(Model model, int boNo) {
		model.addAttribute("Article", boardService.adoptDetail(boNo));
		//model.addAttribute("reply", boardService.getAdoptReply(boNo));
		return "board/adoptArticle";
	};
	
	//분양게시판 게시글 + 댓글 삭제
	@DeleteMapping("delAdopt")
	@ResponseBody
	public int delAdopt(int boNo, String Uid) {
		System.out.println(boNo + ", " + Uid);
		return boardService.delAdopt(boNo, Uid);
	};
	
	//분양게시판 게시글 수정페이지
	@GetMapping("modAdopt")
	public String modAdopt(Model model, int boNo, @AuthenticationPrincipal PrincipalDetails principal) {
		model.addAttribute("Article", boardService.adoptDetail(boNo));
		model.addAttribute("id", principal.getUser().getMeId());
		model.addAttribute("code", codeService.getCodes("DG", "CT", "SX", "AS", "BA", "AA", "YN"));
		//												멍품종  냥품종   성별  분양상태  동물   지역  중성화여부
		model.addAttribute("originalInfo",boardService.getadoptInfo(boNo));
		return "board/modAdopt";
	};
	
	//분양게시판 게시글 수정(+분양정보)
	@PostMapping("updateAdopt")
	@ResponseBody
	public int updateAdopt(BoardVO vo) {
		return boardService.updateAdopt(vo);
	}
	
	//분양게시판 댓글조회
	@PostMapping("getAdoptReply")
	@ResponseBody
	public List<BoardVO> getAdoptReply(int boNo){
		return boardService.getAdoptReply(boNo);
	};

	//분양게시판 댓글등록
	@PostMapping("insertAdoptReply")
	@ResponseBody
	public int insertAdoptReply(BoardVO vo) {
		return boardService.insertAdoptReply(vo);
	};
	
	//분양게시판 댓글삭제
	@DeleteMapping("deleteAdoptReply")
	@ResponseBody
	public int deleteAdoptReply(int commentId) {
		return boardService.deleteAdoptReply(commentId);
	};
	
	//분양게시판 댓글수정
	@PostMapping("updateReply")
	@ResponseBody
	public int updateReply(int commentId, String subject) {
		return boardService.updateReply(commentId, subject);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
