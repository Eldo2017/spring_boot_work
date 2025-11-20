package com.study.shop.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.shop.domain.Member;
import com.study.shop.service.MemberService;

@RestController
@RequestMapping("/react")
public class MemberController {
	@Autowired
	MemberService memberService;
	
	@GetMapping("/email-check")
	public boolean emailCheck(@RequestParam(value="email") String email) {
		System.out.println(email);
		return !memberService.emailCheck(email);
	}
	
	@PostMapping("/signup")
	public ResponseEntity<String> insertMember(@RequestBody Member member) {
		System.out.println(member);
		try {
			memberService.insertMember(member);
			return ResponseEntity.ok("회원가입 성공");
		} catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("회원가입 실패");
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Member member) {
		System.out.println(member.getEmail());
		System.out.println(member.getPassword());
		Member m = memberService.login(member);
		if(m != null) {
			Map<String, Object> userInfo = new HashMap<>();
			userInfo.put("name", m.getName());
			userInfo.put("email", m.getEmail());
			return ResponseEntity.ok(userInfo);
		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
		}
	}
}