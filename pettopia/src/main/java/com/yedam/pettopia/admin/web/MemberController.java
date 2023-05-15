package com.yedam.pettopia.admin.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.pettopia.admin.MemberVO;
import com.yedam.pettopia.admin.service.MemberService;
import com.yedam.pettopia.common.service.CodeService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	
	@Autowired
	CodeService codeService;
	
	@GetMapping("memberMag")
	public String memberMag(Model model) {
		model.addAttribute("code", codeService.getCodes("SC"));
		return "admin/memberMag";
	}
	
	@GetMapping("memberList")
	@ResponseBody
	public List<MemberVO> memberList(){
		return memberService.selectMemberList();
	}
	

	@GetMapping("searchMbr")
	@ResponseBody
	public List<MemberVO> searchMbr(MemberVO memberVO){
		return memberService.searchList(memberVO);
	}
	
	
}
