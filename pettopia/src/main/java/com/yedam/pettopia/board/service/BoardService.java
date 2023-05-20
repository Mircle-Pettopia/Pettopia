package com.yedam.pettopia.board.service;

import java.util.List;

import com.yedam.pettopia.board.vo.BoardTestVO;
import com.yedam.pettopia.board.vo.BoardVO;

public interface BoardService {
	public int insertArticle(BoardTestVO vo);
	public BoardTestVO showArticle(String no);
	public int insertKnowhowArticle(BoardVO vo);
	public List<BoardVO> knowHowList (int page,String keyword);
	public int knowHowMaxPage(String keyword);
	public BoardVO showKnowHow(int boNo);
	public List<BoardVO> getknowHowReply(int boNo);
	public int insertKnowHowReply(BoardVO vo);
	public void KnowHowAddhit(int boNo);
	public int delKnowHow(int boNo,String Uid);
	public String getKnowHowWriter(int boNo);
	public int updateKnowHow(BoardVO vo);
	public int delKnowHowReply(int commentId);
	
	//=========================================
	//--분양게시판
	
	//전체조회
	public List<BoardVO> adoptAllList(int page, String petType, String breed, String sex, String city);
	//분양게시판 개수
	public int adoptMaxPage(String petType, String breed, String sex, String city);
	//분양게시판 단건조회
	public BoardVO adoptDetail(int boNo);
	//분양게시판 게시글 등록
	public int insertAdoptArticle(BoardVO vo);
	//분양게시판 게시글 수정
	public int updateAdopt(BoardVO vo);
	//분양게시판 게시글 수정할 때 품종 select value 줄려고 만든거임
	public BoardVO getadoptInfo(int boNo);
	//분양게시판 단건조회 - 게시글 + 댓글 삭제
	public int delAdopt(int boNo,String Uid);
	//분양게시판 단건조회 - 게시글 댓글 삭제시 본인글을 삭제하는지 확인
	public String getAdoptWriter(int boNo);
	//분양게시판 단건조회 - 댓글
	public List<BoardVO> getAdoptReply(int boNo);
	//분양게시판 단건조회 - 댓글등록
	public int insertAdoptReply(BoardVO vo);
	//분양게시판 단건조회 - 댓글삭제
	public int deleteAdoptReply(int commentId);
	//분양게시판 단건조회 - 댓글수정
	public int updateReply(int commentId, String subject);
	
	
}
