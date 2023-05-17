package com.yedam.pettopia.board.mapper;

import java.util.List;

import com.yedam.pettopia.board.vo.BoardTestVO;
import com.yedam.pettopia.board.vo.BoardVO;

public interface BoardMapper {
	public int insertArticle(BoardTestVO vo);
	public BoardTestVO showArticle(String no);
	public int insertKnowhowArticle(BoardVO vo);
	public List<BoardVO> knowHowList (int page,String keyword);
	public int knowHowMaxPage(String keyword);
	public BoardVO showKnowHow(int boNo);
	public List<BoardVO> getknowHowReply(int boNo);
	public int insertKnowHowReply(BoardVO vo);
	public void KnowHowAddhit(int boNo);
	public int delKnowHow(int boNo);
	public int delKnowHow2(int boNo);
	public String getKnowHowWriter(int boNo);
	public int updateKnowHow(BoardVO vo);
	public int delKnowHowReply(int commentId);
	
	//은애!!!
	public List<BoardVO> getmyKnowHowWriterList(int page, String keyword, String meId);
	public int myknowHowMaxPage(String keyword, String meId);
}
