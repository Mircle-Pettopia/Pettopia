package com.yedam.pettopia.admin;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

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
	
	// 이미지
	private MultipartFile[] img;
	private MultipartFile imgMain;
	private String imgId;
	private String prdtImg;
	private String isMain;
	
	//옵션
	private String optId;
	private String optNm;
	private String optDetaId;
	private String optDetaNm;
	private int addPrc;
	private String[] optionArr;

}
