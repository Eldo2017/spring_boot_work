package com.study.springboot.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.domain.Member;
import com.study.springboot.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService mService;
	
	@RequestMapping("/")
	public String root() {
		return "index";
	}
	
	@PostMapping("/minsert")
	public String minsert(Member member, Model model) {
		Member res = mService.insert(member);
		model.addAttribute("member", res);
		model.addAttribute("title","회원 등록 성공");
		return "minsert";
	}
	
	@GetMapping("/mupdate")
	public String mupdate(Member member, Model model) {
		Optional<Member> mr = mService.selectById(member.getId());
		Member m = mr.get();
		m.setName(member.getName());
		
		Member ures = mService.insert(m);
		model.addAttribute("member",ures);
		model.addAttribute("title","회원 수정 성공");
		return "minsert";
	}
}