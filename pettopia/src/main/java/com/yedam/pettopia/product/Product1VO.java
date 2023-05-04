package com.yedam.pettopia.product;

import java.util.Base64;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Product1VO {
	private String prdtId;
	private String prdtNm;
	@JsonFormat(shape=JsonFormat.Shape.STRING)
	private byte[] prdtDesct;
	private int prdtPrc;
	private String saleSt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regDt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date modDt;
	private String sCatId;
	private String lCatId;
	
	private int cnt; // 상품 개수

	public void setPrdtDesctFromBase64(String base64) {
        this.prdtDesct = Base64.getDecoder().decode(base64);
    }

//	// getter/setter 메소드
//	public byte[] getPrdtImg() {
//		return prdtImg;
//	}
//	public void setPrdtImg(byte[] prdtImg) {
//		this.prdtImg = prdtImg;
//	}

}
