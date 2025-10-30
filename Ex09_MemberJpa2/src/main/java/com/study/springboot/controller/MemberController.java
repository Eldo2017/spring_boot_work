
package com.study.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.domain.Member;
import com.study.springboot.service.MemberService;

@Controller
public class MemberController {
	@Autowired
	MemberService mService;
	
	@RequestMapping("/")
	public String root() {
		return "menu";
	}
	
	@GetMapping("/insert")
	public String insert() {
		mService.insert();
		return "redirect:/";
	}
	
	@GetMapping("/selectAll")
	public String selectAll(Model model) {
		List<Member> list = mService.selectAll();
		model.addAttribute("list",list);
		return "selectAll";
	}
	
	@GetMapping("/selectById")
	public String selectById(@RequestParam("id") Long id, Model model) {
		Optional<Member> member = mService.selectById(id);
		if(member.isPresent()) {
			model.addAttribute("member", member.get());
			return "select";
		} else {
			model.addAttribute("error","해당 회원의 ID가 없습니다.");
			return "error";
		}
	}
}
