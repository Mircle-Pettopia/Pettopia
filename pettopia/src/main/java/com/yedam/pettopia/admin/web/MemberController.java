package com.yedam.pettopia.admin.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

	
	@GetMapping("memberMag")
	public String memberMag(Model model) {
		return "admin/memberMag";
	}
}
