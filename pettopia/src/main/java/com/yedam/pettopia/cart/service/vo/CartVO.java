package com.yedam.pettopia.cart.service.vo;

import java.util.Date;

import lombok.Data;

@Data
public class CartVO {
	private String crtId;
	private String meId;
	private String prdtId;
	private String optDetaId;
	private int cnt;
	private String optDataNm;
	private int addPrc;
	private String optId;
	private String optNm;
	private String prdtNm;
	private int prdtPrc;
	private String crtDetaId;
	private String optDetaNm;
	private String prdtImg;
	//=====주문파트
	private String ordrId;
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
	//==주문상세
	private String ordtId;
	private int prc;
	//==옵션
	private String ordtOpCd;
	//==결제코드
	private String imp;
	//==키값반환용
	private String newId;
}
