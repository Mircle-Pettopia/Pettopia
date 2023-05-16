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
	public List<CartVO> getCart(String meId) { //장바구니 리스트 호출
		// TODO Auto-generated method stub
		return cartMapper.getCart(meId);
	}
	@Override
	public int setAmount(String crtId, int cnt) { //장바구니 수량조절 UPDATE
		// TODO Auto-generated method stub
		return cartMapper.setAmount(crtId, cnt);
	}
	@Override
	public int delCart(String crtId) { //장바구니 제품삭제
		int result=0;
		result+=cartMapper.delCart(crtId);
		result+=cartMapper.delCartDetail(crtId);
		return result;
	}
	@Override  //주문완료시 주문내역 넣는 메서드
	public String insertOrderHeader(List<CartVO> orderList, CartVO orderInfo) {
		//ordrId는 주문번호
		cartMapper.insertOrderHeader(orderInfo); //주문번호 헤더를 insert하고 key를 저장 이 메서드에서 1번만들어감
		String ordrId = orderInfo.getOrdrId();
		String ordtId = "";
		String OverlapKey = ""; 								//제품 중복확인용 키값
		for(int i=0; i<orderList.size();i++) { 					//for문으로 모든데이터긁기
			if (!OverlapKey.equals(orderList.get(i).getCrtId())) { //중복방지값이 같지않으면          
				OverlapKey=new String(orderList.get(i).getCrtId()); //중복방지값에 현제 제품(장바구니)번호를 넣는다
				//=====주문디테일(제품) 넣기
				orderList.get(i).setOrdrId(ordrId);					//주문디테일에 넣기전에 주문번호 헤더값설정
				cartMapper.insertOrderDetail(orderList.get(i));     //주문디테일 넣고 디테일 키값저장== 결론적으로 제품은 한번만들어감
				ordtId = orderList.get(i).getOrdtId(); 				//옵션에 넣기전에 해당 디테일(제품)번호 설정
			}
			//제품 옵션 넣기
			//옵션은 어차피 모든줄 들어가야되서 중복거르지 않는다. 다만, 주문디테일 키값을 담아서 insert해준다
			orderList.get(i).setOrdtId(ordtId);
			cartMapper.insertOrderOption(orderList.get(i));
		}
		
		
		return ordrId; //주문번호 반환
	}
	@Override
	public int delAllCart(String meId) {
		int result=0;
		List<CartVO> list=cartMapper.getCart(meId);
		for(int i = 0;i<list.size();i++) {
			System.out.println(list.get(i).getCrtId()+"삭제===========");
			result+=cartMapper.delCart(list.get(i).getCrtId());
			result+=cartMapper.delCartDetail(list.get(i).getCrtId());
		}
		return result;
	}
	@Override
	public int cartCount(String meId) {
		// TODO Auto-generated method stub
		return cartMapper.cartCount(meId);
	}

}
