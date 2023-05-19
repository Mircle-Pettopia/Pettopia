package com.yedam.pettopia.admin;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class QnaMagVO {

	private int qstNo;
	private String meId;
	private String title;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regDt;
	private String qstImg;
	private String prdtId;
	private String qstStatus;
	private String qstYn;
	private String content;
	private String name;
	private String prdtNm;
	private int cnt; // 답변 상태 카운트
	
	// 댓글
	private int commentId;
	private String subject;
	private String division; 
	private int boNo;
	private int re;
	
	//검색
	private String[] searchQstSt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDt;
}
