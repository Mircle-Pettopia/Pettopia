package com.yedam.pettopia.cart.mapper;

import java.util.List;

import com.yedam.pettopia.cart.service.vo.CartVO;

public interface CartMapper {
	public List<CartVO> getCart(String meId);
	public int setAmount(String crtId,int cnt);
	public int delCart(String crtId);
	public int delCartDetail(String crtId);
	public String insertOrderHeader(CartVO vo);
	public String insertOrderDetail(CartVO vo);
	public String insertOrderOption(CartVO vo);
	
}
