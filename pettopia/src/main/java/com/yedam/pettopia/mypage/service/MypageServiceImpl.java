package com.yedam.pettopia.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.pettopia.admin.mapper.ProductMapper;
import com.yedam.pettopia.cart.mapper.CartMapper;
import com.yedam.pettopia.cart.service.vo.CartListVO;
import com.yedam.pettopia.cart.service.vo.CartVO;
import com.yedam.pettopia.mypage.MypageVO;
import com.yedam.pettopia.mypage.mapper.MypageMapper;

@Service
public class MypageServiceImpl implements MypageService{
	@Autowired MypageMapper mapper;
	@Autowired ProductMapper pmapper;
	@Autowired CartMapper cmapper;
	
	@Override
	public List<MypageVO> getOrder(String meId) {
		return mapper.getOrder(meId);
	}
	
	//전체 주문디테일 개수 들고온다
	@Override
	public int countOrderList() {
		return mapper.countOrderList();
	}
	//페이징기능
	@Override
	public List<MypageVO> pagingTest(MypageVO vo) {
		return mapper.pagingTest(vo);
	}
	
	@Override
	public MypageVO getOrdrList(String ordrId) {
		return mapper.getOrdrList(ordrId);
	}

	@Override
	public List<MypageVO> getOrderList(MypageVO vo) {
		return mapper.getOrderList(vo);
	}

	@Override
	public List<MypageVO> getPrcCount(String meId) {
		return mapper.getPrcCount(meId);
	}

	@Override
	public List<MypageVO> getShipCount(String meId) {
		return mapper.getShipCount(meId);
	}

	@Override
	public MypageVO ordtIdOptionInfo(String ordtId) {
		return mapper.ordtIdOptionInfo(ordtId);
	}

	@Override
	public List<MypageVO> ordrDetailList(String ordrId) {
		return mapper.ordrDetailList(ordrId);
	}

	// 관심상품리스트
	// 옵션 + 옵션디테일 정보도 같이 불러온다
	@Override
	public List<MypageVO> getInterestList(String meId) {
		// 아이디 기준으로 관심상품을 모두 데려온다.
		List<MypageVO> my = mapper.getInterestList(meId);
		//System.out.println("my>>>>>>>>>>>>>>>>>>>>>>>>" + my);
		
		// my를 반복문 돌려서 옵션디테일을 데려온다
		for(MypageVO mvo : my) {
			//System.out.println("mvo>>>>>>>>>>>>>>>>>>>>>>" + mvo);
			mvo.setOptionVal(pmapper.selectOptionDetail(mvo.getPrdtId()));
		}
		
		return my;
	}

	@Override
	public int interestCnt(String meId) {
		return mapper.interestCnt(meId);
	}

	@Override
	public int interestDelete(MypageVO vo) {
		String id = vo.getMeId();
		String check_prdtId = vo.getPrdtId();
		String[] check_prdtId_arr = check_prdtId.split(",");
		
		MypageVO mvo = new MypageVO();
		
		for(int i = 0 ; i < check_prdtId_arr.length ; i++) {
			mvo.setMeId(id);
			mvo.setPrdtId(check_prdtId_arr[i]);
		}
		//System.out.println("mvo>>>>>>>>>>>>>>>>>>>" + mvo);
		return mapper.interestDelete(mvo);
	}

	//	cart + cart_detail INSERT
	@Transactional
	@Override
	public int interstInCart(CartListVO vo) {
		CartVO cvo = new CartVO();
		
		cvo.setPrdtId(vo.getPrdtId());
		cvo.setMeId(vo.getMeId());
		cvo.setCnt(vo.getCnt());
		
		int cnt = cmapper.interstInCart(cvo);
		for(int i = 0 ; i < vo.getOptDetaId().size() ; i++) {
			cvo.setOptDetaId(vo.getOptDetaId().get(i));
			cmapper.interstInCartDetail(cvo);
		}
		
		System.out.println("cnt>>>" + cnt);
		return cnt;
	}


	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
