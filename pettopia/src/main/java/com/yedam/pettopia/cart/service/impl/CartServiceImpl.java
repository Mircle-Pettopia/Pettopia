package com.yedam.pettopia.cart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.pettopia.cart.mapper.CartMapper;
import com.yedam.pettopia.cart.service.CartService;
import com.yedam.pettopia.cart.service.vo.CartVO;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	CartMapper cartMapper;
	@Override
	public List<CartVO> getCart(String meId) {
		// TODO Auto-generated method stub
		return cartMapper.getCart(meId);
	}

}
