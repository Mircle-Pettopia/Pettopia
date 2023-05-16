package com.yedam.pettopia.cart.service.vo;

import java.util.List;
import lombok.Data;

@Data
public class CartListVO {
	private String meId;
	private String prdtId;
	private int cnt;
	private List<String> optDetaId;
}

