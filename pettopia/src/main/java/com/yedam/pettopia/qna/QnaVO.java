package com.yedam.pettopia.qna;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class QnaVO {
	private int qstNo;  //게시글번호
	private String title; //제목
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private Date regDt; //등록일
	private int viewCnt; //조회수
	private String meId; //회원아이디
	private String content; //내용
	private String prdtId; //상품아이디
	private String qstImg; //상품이미지
	private String qstStatus;//문의상태
	private String qstYn; //비밀글여부
	private String division; //댓글구분
	private int boNo; //번호 
	private String commentId; //댓글번호
	private String subject; //댓글내용
	private String keyword;
	private int rn;
	private String boType;
	private String prdtImg;
	private String adId; //관리자id
	private String name; //네임
	
	

}