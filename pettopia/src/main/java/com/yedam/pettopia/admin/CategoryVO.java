package com.yedam.pettopia.admin;

import lombok.Data;

@Data
public class CategoryVO {
	private String lCatId;
	private String lCatNm;
	private String lCatSt;
	private String sCatId;
	private String sCatNm;
	private String sCatSt;
	
	//==============다용도 업데이터에 사용할 변수들=========
	private String Table;
	private String Column;
	private String Value;
	private String ConCol;
	private String ConVal;
}
