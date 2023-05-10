package com.yedam.pettopia.cart.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.pettopia.cart.service.CartService;
import com.yedam.pettopia.cart.service.vo.CartVO;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class CartController {
	@Autowired
	CartService cartService;
	
	@GetMapping("CartMain")
	public String cartMain(Model model) {
		return "cart/cart";
	}
	@GetMapping("OrderMain")
	public String orderMain(Model model) {
		return "cart/order";
	}
	
	@GetMapping("getCart")
	@ResponseBody
	public List<CartVO> getCart(String meId){
		return cartService.getCart(meId); 
	}
	

}
