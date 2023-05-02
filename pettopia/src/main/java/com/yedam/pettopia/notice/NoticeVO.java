package com.yedam.pettopia.notice;

import java.util.Date;

import lombok.Data;

@Data
public class NoticeVO {
	private int noNo;
	private String title;
	private byte[] content;
	private Date rDate;
	private int viewCnt;
	private String file;
	private String meId;

}
