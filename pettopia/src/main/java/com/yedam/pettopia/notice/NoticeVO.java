package com.yedam.pettopia.notice;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class NoticeVO {
	private int noNo;
	private String title;
	@JsonFormat(shape=JsonFormat.Shape.STRING)
	private byte[] content;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date rDate;
	private int viewCnt;
	private String file;
	private String meId;

}
