package com.yedam.pettopia.cart.mapper;

import java.util.List;

import com.yedam.pettopia.cart.service.vo.CartVO;

public interface CartMapper {
	public List<CartVO> getCart(String meId);
}
