package com.study.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.study.springboot.domain.Member;
import com.study.springboot.service.MemberService;

@SessionAttributes("loginUser")
@Controller
public class MemberController {
	@Autowired
	MemberService mService;
	
	@Autowired
	PasswordEncoder pEncoder;
	
	@RequestMapping("/")
	public String root() {
		return "index";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/enrollForm")
	public String enrollForm() {
		return "member/enrollForm";
	}
	
	@GetMapping("/idCheck")
	public @ResponseBody boolean idCheck(@RequestParam("id") String id) {
		return mService.idCheck(id);
	}
	
	@PostMapping("/memberInsert")
	public String memberInsert(Member member) {
		String ePwd = pEncoder.encode(member.getPassword());
		member.setPassword(ePwd);
		mService.insert(member);
		return "redirect:/";
	}
	
	@PostMapping("/login")
	public String login(Member member, Model model) {
		Member loginUser = mService.login(member);

		if (loginUser != null && pEncoder.matches(member.getPassword(), loginUser.getPassword())) {
	        model.addAttribute("loginUser", loginUser);
	        return "index";  // redirect 대신 forward
	    } else {
	        return "member/loginForm"; // 실패 시 다시 로그인 페이지
	    }
		
	}
	/*
	 * @SessionAttributes + model을 통하여 로그인 정보를 관리하는 경우엔
	 *  SessionStatus 객체를 통하여 사용완료 처리를 한다
	 *  - session 객체를 폐기하지 않고 재사용한다
	 */
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		if(!status.isComplete())
			status.setComplete();
		return "redirect:/";
	}
}
