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
	public List<BoardVO> knowHowList (int page,String keyword){
		// TODO Auto-generated method stub
		return boardMapper.knowHowList(page,keyword);
	}

	@Override
	public int knowHowMaxPage(String keyword) {
		// TODO Auto-generated method stub
		return boardMapper.knowHowMaxPage(keyword);
	}

	@Override
	public BoardVO showKnowHow(int boNo) {
		// TODO Auto-generated method stub
		return boardMapper.showKnowHow(boNo);
	}

	@Override
	public List<BoardVO> getknowHowReply(int boNo) {
		// TODO Auto-generated method stub
		return boardMapper.getknowHowReply(boNo);
	}

	@Override
	public int insertKnowHowReply(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardMapper.insertKnowHowReply(vo);
	}

	@Override
	public void KnowHowAddhit(int boNo) {
		// TODO Auto-generated method stub
		boardMapper.KnowHowAddhit(boNo);
	}

	@Override
	public int delKnowHow(int boNo, String Uid) {
		// TODO Auto-generated method stub
		System.out.println("test:"+Uid);
		int result = -1;
		if(getKnowHowWriter(boNo).equals(Uid))
		{
			result = boardMapper.delKnowHow(boNo);
			boardMapper.delKnowHow2(boNo);
		};
		return result;
	}

	@Override
	public String getKnowHowWriter(int boNo) {
		// TODO Auto-generated method stub
		return boardMapper.getKnowHowWriter(boNo);
	}

	@Override
	public int updateKnowHow(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardMapper.updateKnowHow(vo);
	}

	@Override
	public int delKnowHowReply(int commentId) {
		// TODO Auto-generated method stub
		return boardMapper.delKnowHowReply(commentId);
	}

	
	// 분양게시판 전체조회
	@Override
	public List<BoardVO> adoptAllList(BoardVO vo) {
		return boardMapper.adoptAllList(vo);
	}
	

}
