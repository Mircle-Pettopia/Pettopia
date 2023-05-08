package com.yedam.pettopia.board.mapper;

import java.util.List;

import com.yedam.pettopia.board.vo.BoardTestVO;
import com.yedam.pettopia.board.vo.BoardVO;

public interface BoardMapper {
	public int insertArticle(BoardTestVO vo);
	public BoardTestVO showArticle(String no);
	public int insertKnowhowArticle(BoardVO vo);
	public List<BoardVO> knowHowList (int page);
	public int knowHowMaxPage();
	public BoardVO showKnowHow(int boNo);
	public List<BoardVO> getknowHowReply(int boNo);
}
