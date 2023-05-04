package com.yedam.pettopia.board.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private int boNo;
	private String title;
	private String content;
	private Date regDt;
	private int viewCnt;
	private String meId;

}