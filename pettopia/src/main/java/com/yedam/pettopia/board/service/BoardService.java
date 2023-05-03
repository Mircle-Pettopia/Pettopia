package com.yedam.pettopia.board.service;

import com.yedam.pettopia.board.vo.BoardTestVO;

public interface BoardService {
	public int insertArticle(BoardTestVO vo);
	public BoardTestVO showArticle(String no);
}
