package com.yedam.pettopia.mypage;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MypageVO {
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
	
	private int nowPage, startPage, endPage, totals, cntPerPage, lastPage, stars, ends;
	private int cntPage = 8;
	
	public MypageVO() {
	}
	
	public MypageVO(int total, int nowPage, int cntPerPage) {
		setNowPage(nowPage);
		setCntPerPage(cntPerPage);
		setTotals(total);
		calcLastPage(getTotals(), getCntPerPage());
		calcStartEndPage(getNowPage(), cntPage);
		calcStartEnd(getNowPage(), getCntPerPage());
	}
	
	// 제일 마지막 페이지 계산
	public void calcLastPage(int total, int cntPerPage) {
		setLastPage((int) Math.ceil((double)total / (double)cntPerPage));
	}
	
	// 시작, 끝 페이지 계산
	public void calcStartEndPage(int nowPage, int cntPage) {
		setEndPage(((int)Math.ceil((double)nowPage / (double)cntPage)) * cntPage);
		if (getLastPage() < getEndPage()) {
			setEndPage(getLastPage());
		}
		setStartPage(getEndPage() - cntPage + 1);
		if (getStartPage() < 1) {
			setStartPage(1);
		}
	}
	
	// DB 쿼리에서 사용할 start, end값 계산
	public void calcStartEnd(int nowPage, int cntPerPage) {
		setEnds(nowPage * cntPerPage);
		setStars(getEnds() - cntPerPage + 1);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
