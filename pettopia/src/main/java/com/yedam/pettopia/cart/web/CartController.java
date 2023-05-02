package com.yedam.pettopia.cart.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {
	@GetMapping("CartMain")
	public String cartMain(Model model) {
		return "cart/cart";
	}
	@GetMapping("OrderMain")
	public String orderMain(Model model) {
		return "cart/order";
	}
}
