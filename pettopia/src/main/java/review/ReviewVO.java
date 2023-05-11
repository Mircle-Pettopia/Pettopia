package review;

import java.util.Date;

import lombok.Data;

@Data
public class ReviewVO {
	private int reNO;
	private String title;
	private String content;
	private Date creatDt;
	private int reImg;
	private String point;
	private String meId;
	private String ordtId;
	private String prdtId;
}
