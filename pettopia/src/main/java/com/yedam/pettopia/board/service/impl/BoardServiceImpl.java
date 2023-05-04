package com.yedam.pettopia.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.pettopia.board.mapper.BoardMapper;
import com.yedam.pettopia.board.service.BoardService;
import com.yedam.pettopia.board.vo.BoardTestVO;
import com.yedam.pettopia.board.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardMapper boardMapper;

	@Override
	public int insertArticle(BoardTestVO vo) {
		// TODO Auto-generated method stub
		return boardMapper.insertArticle(vo);
	}

	@Override
	public BoardTestVO showArticle(String no) {
		// TODO Auto-generated method stub
		System.out.println(no);
		return boardMapper.showArticle(no);
	}

	@Override
	public int insertKnowhowArticle(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardMapper.insertKnowhowArticle(vo);
	}

	@Override
	public List<BoardVO> knowHowList(int page) {
		// TODO Auto-generated method stub
		return boardMapper.knowHowList(page);
	}

}
