package com.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	@RequestMapping("/")
	
	public @ResponseBody String root() {
		return "jsp�� �����մϴ�";
	}
	
	@RequestMapping("/test1")
	public String test1() {
		return "test1"; // ���� ȣ��� �� : /WEB-INF/views/test1.jsp
	}
	
	@RequestMapping("/test2")
	public String test2() {
		return "sub/test2"; // ���� ȣ��� �� : /WEB-INF/views/sub/test2.jsp
	}
}
