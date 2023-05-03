package com.yedam.pettopia.board.mapper;

import com.yedam.pettopia.board.vo.BoardTestVO;

public interface BoardMapper {
	public int insertArticle(BoardTestVO vo);
	public BoardTestVO showArticle(String no);
}
