package com.yedam.pettopia.admin.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.pettopia.admin.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;
	
	
	
	@GetMapping("memberMag")
	public String memberMag(Model model) {
		return "admin/memberMag";
	}
	

	@GetMapping("memberList")
	@ResponseBody
	public List<MemberVO> memberList(){
		return memberService.selectMemberList();
	}
}
