package com.yedam.pettopia.qna.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.yedam.pettopia.qna.service.QnaService;
import com.yedam.pettopia.user.auth.PrincipalDetails;

@Controller
public class QnaController {
	@Autowired
	QnaService qnaService;
	
	
	@GetMapping("QnaList")
	public String QnaList(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails,
			Authentication authentication) {
		
		String result = "";
		String meId= principalDetails.getUser().getMeId();
		model.addAttribute("qnaList", qnaService.qnaAllList(meId));
		Object context = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		// System.out.println("어느소속이냐=====" + principal.getUser().getSignPath());

		// 익명사용자도 페이지 접근이 가능하도록 진행하기
		// 참고 :
		// https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=phrack&logNo=80202619173
		if (context != "anonymousUser") {
			PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
			if (principal.getUser().getSignPath() == "company") {
				result += principal;
				model.addAttribute("id", principal.getUser().getMeId());
				model.addAttribute("name", principal.getUser().getName());

				System.out.println(model);
			} else {
				result += principal;
				model.addAttribute("meId", principal.getUser().getMeId());
				model.addAttribute("name", principal.getUser().getName());
				model.addAttribute("token", principal.getUser().getMeSnsToken());
			}
			;
		}
		;return "qna/qna";
	}
	
	@GetMapping("QnaForm")
	public String QnaForm(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails,
			Authentication authentication) {
		
		String result = "";
		String meName= principalDetails.getUser().getName();
		Object context = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		// System.out.println("어느소속이냐=====" + principal.getUser().getSignPath());

		// 익명사용자도 페이지 접근이 가능하도록 진행하기
		// 참고 :
		// https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=phrack&logNo=80202619173
		if (context != "anonymousUser") {
			PrincipalDetails principal = (PrincipalDetails) authentication.getPrincipal();
			if (principal.getUser().getSignPath() == "company") {
				result += principal;
				model.addAttribute("id", principal.getUser().getMeId());
				model.addAttribute("name", principal.getUser().getName());

				System.out.println(model);
			} else {
				result += principal;
				model.addAttribute("meId", principal.getUser().getMeId());
				model.addAttribute("meName", principal.getUser().getName());
				model.addAttribute("token", principal.getUser().getMeSnsToken());
			}
			;
		}return "qna/qnaForm";
	}
	@GetMapping("QnaDetail")
	public String QnaDetail(Model model) {
		return "qna/qnaDetail";
	}
}
