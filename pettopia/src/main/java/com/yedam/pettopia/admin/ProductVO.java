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
	
	// 공통 코드
	private String codCd;
	private String codTitle;
	
	// 카테고리
	private String lCatNm;
	private String sCatNm;
	
	private int cnt; // 상품 개수
	
	// 이미지
	private MultipartFile[] img;
	private MultipartFile imgMain;
	private String imgId;
	private String prdtImg;
	private String isMain;
	
	//옵션
	private String option;

}
