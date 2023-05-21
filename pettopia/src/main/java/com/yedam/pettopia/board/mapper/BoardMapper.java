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
	public List<BoardVO> getBoardAllList(int page, String keyword, String meId, String boType);
	public int boardAllMaxPage(String keyword, String meId, String boType);
	
	//분양게시판
	public List<BoardVO> adoptAllList(int page, String petType, String breed, String sex, String city);
	public int adoptMaxPage(String petType, String breed, String sex, String city);
	public BoardVO adoptDetail(int boNo);
	public int insertAdoptArticle(BoardVO vo);
	public int insertAdoptInfo(BoardVO vo);
	public int updateAdopt(BoardVO vo);
	public BoardVO getadoptInfo(int boNo);
	
	//분양게시판 + 댓글 삭제 + 분양정보
	public int delAdoptBoardAndReply(int boNo);
	public String getAdoptWriter(int boNo);
	public int delAdoptInfo(int boNo);
	
	//분양게시판 댓글
	public List<BoardVO> getAdoptReply(int boNo);
	public int insertAdoptReply(BoardVO vo);
	public int deleteAdoptReply(int commentId);
	public int updateReply(int commentId, String subject);
}
