package com.yedam.pettopia.user.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.pettopia.user.UserVO;
import com.yedam.pettopia.user.service.UserService;


@Controller
public class UserController { 
	@Autowired
	private UserService service;
	
	@GetMapping("/")
    public String home(Model model) { // 인증된 사용자의 정보를 보여줌
        /*Long id = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
        // token에 저장되어 있는 인증된 사용자의 id 값
        
        UserVO userVo = service.getMeId(id);
        userVo.setPw(null); // password는 보이지 않도록 null로 설정
        model.addAttribute("user", userVo);*/
        return "index";
    }
	
	//어드민 회원관리 정보인가?
	@GetMapping("/userList")
    public String getUserList(Model model) { // User 테이블의 전체 정보를 보여줌
        List<UserVO> userList = service.getUserList();
        model.addAttribute("list", userList);
        return "userListPage";
    }
	
	//로그인페이지
	@GetMapping("/login")
	public String loginPage() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken)
            return "login";
        return "redirect:/";
	}
	
	@PostMapping("/signup")
    public String signup(UserVO userVo) { // 회원 가입
        try {
        	service.signup(userVo);
        } catch (DuplicateKeyException e) {
            return "redirect:/signup?error_code=-1";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/signup?error_code=-99";
        }
        return "redirect:/login";
    }
}
