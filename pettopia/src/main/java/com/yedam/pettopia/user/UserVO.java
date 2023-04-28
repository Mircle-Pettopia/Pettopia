package com.yedam.pettopia.user;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class UserVO {
	private String meId;
	private String pw;
	private String name;
	private String phone;
	private String post;
	private String addr;
	private String addrDetail;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date signDt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updateDt;
	private String signPath;
	private String outYn;
	private String role;
}
