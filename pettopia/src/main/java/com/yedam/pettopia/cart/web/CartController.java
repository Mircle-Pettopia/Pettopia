package com.yedam.pettopia.cart.web;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yedam.pettopia.cart.service.CartService;
import com.yedam.pettopia.cart.service.vo.CartVO;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
//@AllArgsConstructor
public class CartController {

	final CartService cartService;
	
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
	
	//장바구니 수량 ajax 통신 update용
	@PostMapping("setAmount")
	@ResponseBody
	public int setAmount(String crtId,int cnt) {
		return cartService.setAmount(crtId, cnt);
	}
	
	@DeleteMapping("delCart")
	@ResponseBody
	public int delCart(String crtId) {
		return cartService.delCart(crtId);
	}
	
	@PostMapping("insertOrder")
	@ResponseBody
	public String insertOrder(@RequestBody final HashMap<String, Object> map) {
		Gson gson = new Gson();
		Type listType = new TypeToken<ArrayList<CartVO>>(){}.getType();
		List<CartVO> orderList = gson.fromJson(map.get("cartData").toString(), listType);
		CartVO orderInfo =gson.fromJson(map.get("userData").toString(), CartVO.class);
	
		return cartService.insertOrderHeader(orderList,orderInfo);
	}
}
