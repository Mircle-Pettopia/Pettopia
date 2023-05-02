package com.yedam.pettopia.cart.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {
	@GetMapping("CartMain")
	public String artMain(Model model) {
		return "cart/cart";
	}
}
