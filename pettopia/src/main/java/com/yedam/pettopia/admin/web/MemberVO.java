package com.yedam.pettopia.admin.web;


import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MemberVO {

	private String meId;
	private String name;
	private String phone;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String signDt;
}
