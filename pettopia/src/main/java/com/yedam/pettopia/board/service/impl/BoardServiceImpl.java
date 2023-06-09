package com.yedam.pettopia.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		boardMapper.insertKnowhowArticle(vo);
		return vo.getBoNo();
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
	
	@Transactional
	@Override
	public int insertAdoptArticle(BoardVO vo) {
		int result = boardMapper.insertAdoptArticle(vo);
		
		if(result > 0) {
			boardMapper.insertAdoptInfo(vo);
		}
		
		return result;
	}
	
	@Transactional
	@Override
	public int updateAdopt(BoardVO vo) {
		int result = boardMapper.updateKnowHow(vo);
		
		if(result > 0) {
			boardMapper.updateAdopt(vo);
		};
		
		return result;
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

	@Transactional
	@Override
	public int delAdopt(int boNo, String Uid) {			// 글삭제 + 댓글삭제 + 분양정보삭제
		System.out.println("test:" + Uid);
		int result = -1;
		if(getAdoptWriter(boNo).equals(Uid)) {
			result = boardMapper.delKnowHow(boNo);
			
			if(result > 0) {
				boardMapper.delKnowHow2(boNo);
				boardMapper.delAdoptInfo(boNo);
			}
		};
		return result;
	}

	@Override
	public String getAdoptWriter(int boNo) {
		return boardMapper.getAdoptWriter(boNo);
	}

	@Override
	public BoardVO getadoptInfo(int boNo) {
		return boardMapper.getadoptInfo(boNo);
	}

	@Override
	public int updateReply(int commentId, String subject) {
		return boardMapper.updateReply(commentId, subject);
	}



	
	

}
