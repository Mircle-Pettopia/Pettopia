package com.yedam.pettopia.cart.service.vo;

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
}
