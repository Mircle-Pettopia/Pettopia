package com.yedam.pettopia.cart.service;

import java.util.List;

import com.yedam.pettopia.cart.service.vo.CartVO;

public interface CartService {
	public List<CartVO> getCart(String meId);
	public int setAmount(String crtId,int cnt);
	public int delCart(String crtId);
	public String insertOrderHeader(List<CartVO> orderList,CartVO orderInfo);
	public int delAllCart(String meId);
	public int cartCount(String meId);
}
