package com.yedam.pettopia.admin;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class OrderVO {

	
	// 주문 헤더
	private String ordrId;
	private String meId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ordrDate;
	private String rcvPsn;
	private String rcvPhone;
	private String rcvAddr;
	private int ttPrc;
	private String mthd;
	private long invo;
	private int shipPrc;
	private String prcSt;
	private String shipSt;
	private int point;
	private String note;
		
	// 주문 디테일
	private String ordtId;
	private String prdtId;
	private String optDetaId;
	private int cnt;
	private int prc;
	
	// 회원
	private String name;
	
	// 상품 이름
	private String prdtNm;
	
	//검색
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	private String[] prcStSearch;
	private String[] shipStSearch;
}
