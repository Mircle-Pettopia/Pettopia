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
		return boardMapper.insertArticle(vo);
	}

	@Override
	public BoardTestVO showArticle(String no) {
		System.out.println(no);
		return boardMapper.showArticle(no);
	}

	@Override
	public int insertKnowhowArticle(BoardVO vo) {
		return boardMapper.insertKnowhowArticle(vo);
	}

	@Override
	public List<BoardVO> knowHowList (int page,String keyword){
		return boardMapper.knowHowList(page,keyword);
	}

	@Override
	public int knowHowMaxPage(String keyword) {
		return boardMapper.knowHowMaxPage(keyword);
	}

	@Override
	public BoardVO showKnowHow(int boNo) {
		return boardMapper.showKnowHow(boNo);
	}

	@Override
	public List<BoardVO> getknowHowReply(int boNo) {
		return boardMapper.getknowHowReply(boNo);
	}

	@Override
	public int insertKnowHowReply(BoardVO vo) {
		return boardMapper.insertKnowHowReply(vo);
	}

	@Override
	public void KnowHowAddhit(int boNo) {
		boardMapper.KnowHowAddhit(boNo);
	}

	@Override
	public int delKnowHow(int boNo, String Uid) {
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
		return boardMapper.getKnowHowWriter(boNo);
	}

	@Override
	public int updateKnowHow(BoardVO vo) {
		return boardMapper.updateKnowHow(vo);
	}

	@Override
	public int delKnowHowReply(int commentId) {
		return boardMapper.delKnowHowReply(commentId);
	}

	
	// 분양게시판 전체조회
	@Override
	public List<BoardVO> adoptAllList(int page, String petType, String breed, String sex, String city) {
		return boardMapper.adoptAllList(page, petType, breed, sex, city);
	}

	@Override
	public int adoptMaxPage(String petType, String breed, String sex, String city) {
		return boardMapper.adoptMaxPage(petType, breed, sex, city);
	}

	@Override
	public BoardVO adoptDetail(int boNo) {
		return boardMapper.adoptDetail(boNo);
	}

	@Override
	public List<BoardVO> getAdoptReply(int boNo) {
		return boardMapper.getAdoptReply(boNo);
	}

	@Override
	public int insertAdoptReply(BoardVO vo) {
		return boardMapper.insertAdoptReply(vo);
	}

	@Override
	public int deleteAdoptReply(int commentId) {
		return boardMapper.deleteAdoptReply(commentId);
	}

	@Override
	public int delAdopt(int boNo, String Uid) {
		System.out.println("test:" + Uid);
		int result = -1;
		if(getAdoptWriter(boNo).equals(Uid)) {
			result = boardMapper.delKnowHow(boNo);
			boardMapper.delKnowHow2(boNo);
		};
		return result;
	}

	@Override
	public String getAdoptWriter(int boNo) {
		return boardMapper.getAdoptWriter(boNo);
	}
	

}
