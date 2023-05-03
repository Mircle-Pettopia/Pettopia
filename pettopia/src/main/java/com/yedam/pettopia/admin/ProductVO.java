package com.yedam.pettopia.admin;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


import lombok.Data;

@Data
public class ProductVO {
	private String prdtId;
	private String prdtNm;
	private String prdtDesct;
	private int prdtPrc;
	private String saleSt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regDt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date modDt;
	private String sCatId;
	private String lCatId;
	
	private int cnt; // 상품 개수

//	// getter/setter 메소드
//	public byte[] getPrdtImg() {
//		return prdtImg;
//	}
//	public void setPrdtImg(byte[] prdtImg) {
//		this.prdtImg = prdtImg;
//	}

}
