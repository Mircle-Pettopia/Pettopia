package com.yedam.pettopia.admin;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberVO {

	private String meId;
	private String name;
	private String phone;
	private String signDt;
	private String updateDt;
	private String signPath;
	private String outYn;
	private String role;
	private String post;
	private String addr;
	private String addrDetail;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date start;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date end;
	
	private String[] searchPath;
	
	//공통코드
	private String codCd;
	private String codTitle;
}
