package com.yedam.pettopia.mypage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.pettopia.admin.mapper.ProductMapper;
import com.yedam.pettopia.board.mapper.BoardMapper;
import com.yedam.pettopia.board.vo.BoardVO;
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
	@Autowired BoardMapper bmapper;
	
	@Override
	public List<MypageVO> getOrder(String meId) {
		return mapper.getOrder(meId);
	}
	
	//전체 주문디테일 개수 들고온다
	@Override
	public int countOrderList(String meId) {
		return mapper.countOrderList(meId);
	}
	//페이징기능
	@Override
	public List<MypageVO> pagingTest(String meId, String start, String end, String shipSt, String prcSt, int page) {
		return mapper.pagingTest(meId, start, end, shipSt, prcSt, page);
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
	public int interestDelete(MypageVO vo, String[] arr) {
		int result = 0;
		String id = vo.getMeId();
		
		MypageVO mvo = new MypageVO();
		
		for(int i = 0 ; i < arr.length ; i++) {
			mvo.setPrdtId(arr[i]);
			mvo.setMeId(id);
			result += mapper.interestDelete(mvo);
		}
		return result; 
	}

	//cart + cart_detail INSERT
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
	
	//나의 작성한 게시글 조회!
	@Override
	public List<BoardVO> getBoardAllList(int page, String keyword, String meId, String boType) {
		return bmapper.getBoardAllList(page, keyword, meId, boType);
	}

	@Override
	public int boardAllMaxPage(String keyword, String meId, String boType) {
		return bmapper.boardAllMaxPage(keyword, meId, boType);
	}

	@Override
	public int orderCancel(String ordrId) {
		return mapper.orderCancel(ordrId);
	}

	@Override
	public int orderMaxPage(String meId, String start, String end, String shipSt, String prcSt) {
		return mapper.orderMaxPage(meId, start, end, shipSt, prcSt);
	}


	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
