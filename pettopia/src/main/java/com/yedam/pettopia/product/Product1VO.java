package com.yedam.pettopia.product;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class Product1VO {
	private String prdtId; //상품아이디
	private String prdtNm; //상품이름
	@JsonFormat(shape=JsonFormat.Shape.STRING)
	private String prdtDesct;  //상품설명
	private int prdtPrc; //상품가격
	private String saleSt; //판매상태
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regDt; //등록일자
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date modDt; //수정일자
	private String sCatId; //소분류아이디
	private String lCatId; //대분류아이디
	
	private int cnt; // 상품 개수

	//상품옵션
	private String optId; //옵션id
	private String optNm; //옵션이름
	
	//옵션디테일
	private String optDetaId; //옵션상세id
	private String optDetaNm; //옵션상세명
	private int addPrc; //옵션추가가격
	
	
	//카테고리 항목
	private String sCatNm; //대분류이름
	private String sCatSt; //사용여부
	
	//이미지
	private String imgId; //이미지 id
	private String prdtImg; //상품 이미지
	private String isMain; //대표이미지 여부 y or n 으로 구분
	
}
