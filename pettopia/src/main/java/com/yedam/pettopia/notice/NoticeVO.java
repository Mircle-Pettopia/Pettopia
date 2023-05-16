package com.yedam.pettopia.notice;


import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class NoticeVO {
	private int noNo;
	private String title;
	private String contents;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date rDate;
	private int viewCnt;
	private String files;
	private String meId;
	
	private MultipartFile partFile;
	private String searchKeyword;
}
