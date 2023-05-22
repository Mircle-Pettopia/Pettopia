package com.yedam.pettopia.mypage;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.yedam.pettopia.admin.OptionDetailVO;

import lombok.Data;

@Data
public class MypageVO {
	
	//옵션
	private List<OptionDetailVO> optionVal;
	
	//주문내역 확인
	
	//order_detail
	private String ordtId;
	private String prdtId;
	private String prdtNm;
	private String optDetId;
	private int cnt;			//개수
	private int prc;			//단가
	
	//order_header
	private String ordrId;
	private String meId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date ordrDate;
	private String rcvPsn;
	private String rcvPhone;
	private String rcvAddr;
	private int ttPrc;
	private String mthd;
	private long invo;
	private int shipPrc;
	private String prcSt;
	private String shipSt;
	private int point;
	private String note;
	
	//-------------주문내역 확인 끝
	private String prdtImg;		//상품이미지
	private String prdNm;		//상품이름
	private String sCatNm;		//소분류명
	private String optDetaNm;	//옵션상세명
	private String optNm;		//옵션명
	private String optId;
	
	//------------------------
	private int price;			//상품금액 + 옵션추가금액
	private String start;
	private String end;
	private int total;
	private int prcCount;
	private int shipCount;
	private int page;
	private int rn;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date intInDt;
	private int prdtPrc;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
