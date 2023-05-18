package com.yedam.pettopia.board.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardVO {
	private int boNo;
	private String title;
	private String subject;
	@DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
	private Date regDt;
	private int viewCnt;
	private String meId;
	private int commentId;
	private String division;
	private String re;
	private String keyword;
	private int rn;
	private String boType;
	
	
	//ADOPT(분양정보)
	private int adoptId;
	private String petType;
	private String breed;
	private String sex;
	private String netuered;
	private int age;
	private String status;
	private String phone;
	private String city;
	private int charge;
}