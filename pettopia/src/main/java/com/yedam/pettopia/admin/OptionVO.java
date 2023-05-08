package com.yedam.pettopia.admin;

import java.util.List;

import lombok.Data;

@Data
public class OptionVO {
	
	//옵션
	private String prdtId;
	private String optId;
	private String optNm;
	private List<OptionDetailVO> optionVal;

}
