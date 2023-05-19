package com.yedam.pettopia.notice;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	private int pageNo; //페이지 번호
	private int amount; //페이지당 데이터 수
	private String keyword; //검색
	
	public Criteria() {
		this(1, 10);
	}
	
	public Criteria(int pageNo, int amount) {
		this.pageNo = pageNo;
		this.amount = amount;
	}
	
	public String Keyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}


	}