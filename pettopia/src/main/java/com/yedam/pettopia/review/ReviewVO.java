package com.yedam.pettopia.review;

import java.util.Date;

import lombok.Data;

@Data
public class ReviewVO {

	private int reNo;			//후기번호
	private String contents;	//내용
	private Date creatDt;		//작성날짜
	private int reImg;			//이미지번호
	private String point;		//별점
	
	private String meId;		//아이디
	
	private String ordtId;		//주문디테일번호
	private String prdtId;		//상품ID
	
	
	
	private String prdtNm;		//상품이름
	private String prdtImg;		//상품 이미지
	private String shipSt;		//배송상태
	private Date ordrDate;		//주문일
	
	
}
