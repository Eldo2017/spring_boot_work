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

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("loginUser")
// @SessionAttributes({"loginUser", "", ""})  sesseion cope가 여러개 일 때
public class MemberController {
	@Autowired
	MemberService mService;
	
	@Autowired
	PasswordEncoder pEncoder;
	
	@Autowired
	HttpSession session;
	
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
		// String enPwd = pEncoder.encode(member.getPassword());
		member.setPassword(pEncoder.encode(member.getPassword()));
		mService.insert(member);
		return "redirect:/";
	}

	@PostMapping("/login")
	public String login(Member member, Model model) {
	    // ✅ 이미 로그인된 상태라면 다시 로그인 안되게
	    Member sessionUser = (Member) session.getAttribute("loginUser");
	    if (sessionUser != null) {
	        return "redirect:/";  // 이미 로그인 상태면 메인으로
	    }

	    Member loginUser = mService.login(member); // loginUser != null -> id 있다

	    if (loginUser != null && pEncoder.matches(member.getPassword(), loginUser.getPassword())) {
	        model.addAttribute("loginUser", loginUser); // 세션 등록
	    }

	    String boardDetailUrl = (String) session.getAttribute("boardDetailUrl");
	    if (boardDetailUrl == null) {
	        boardDetailUrl = "/";
	    }

	    return "redirect:" + boardDetailUrl;
	}
	/*
	 * @SessionAttributes + model을 통해 로그인 정보를 관리하는 경우
	    SessionStatus객체를 통해 사용완료 처리를 해야됨.
	    - session객체를 폐기하지 않고 재사용
	 */
	@GetMapping("/logout")
	public String logout(SessionStatus status) {
		if(!status.isComplete())
			status.setComplete();
		return "redirect:/";
	}
}