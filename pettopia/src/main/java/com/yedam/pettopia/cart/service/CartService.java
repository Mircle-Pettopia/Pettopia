package com.yedam.pettopia.cart.service;

import java.util.List;

import com.yedam.pettopia.cart.service.vo.CartVO;

public interface CartService {
	public List<CartVO> getCart(String meId);
}
