package com.yedam.pettopia.admin;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ReviewMagVO {
	
	private int reNo;			//후기번호
	private String contents;	//내용
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date creatDt;		//작성날짜
	private int reImg;			//이미지번호
	private String point;		//별점
	
	private String meId;		//아이디
	
	private String ordtId;		//주문디테일번호
	private String prdtId;		//상품ID
	
	
	
	private String prdtNm;		//상품이름
	private String prdtImg;		//상품 이미지
	private String shipSt;		//배송상태
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ordrDate;		//주문일

	
	private String revNo;
	private String revContent;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date revDt;
	
	
	// 댓글
	private int commentId;
	private String subject;
	private String division; 
	private int boNo;
	private int re;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date start;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date end;
	
}
