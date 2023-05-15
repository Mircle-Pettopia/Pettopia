package com.yedam.pettopia.cart.mapper;

import java.util.List;

import com.yedam.pettopia.cart.service.vo.CartVO;

public interface CartMapper {
	public List<CartVO> getCart(String meId);
	public int setAmount(String crtId,int cnt);
	public int delCart(String crtId);
	public int delCartDetail(String crtId);
	public int insertOrderHeader(CartVO vo);
	public int insertOrderDetail(CartVO vo);
	public int insertOrderOption(CartVO vo);
	public int cartCount(String meId);
	
}
