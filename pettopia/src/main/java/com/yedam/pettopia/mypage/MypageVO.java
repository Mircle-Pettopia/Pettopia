package com.yedam.pettopia.mypage;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MypageVO {
	//주문내역 확인
	
	//order_detail
	private String ordtId;
	private String prdtId;
	private String optDetId;
	private int cnt;
	private int prc;
	
	//order_header
	private String ordrId;
	private String meId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ordrDate;
	private String rcvPsn;
	private String rcvPhone;
	private String rcvAddr;
	private int ttPrc;
	private String mthd;
	private int invo;
	private int shipPrc;
	private String prcSt;
	private String shipSt;
	private int point;
	private String note;
	
	//-------------주문내역 확인 끝
	private String prdtImg;		//상품이미지
	private String prdNm;		//상품이름
	private String sCatNm;		//소분류명
	
	//------------------------
	private int price;			//상품금액 + 옵션추가금액
	private int count;			//하나의 주문번호에 몇개의 상세주문건이 있는지
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
