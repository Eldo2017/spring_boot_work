package com.study.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.springboot.domain.Reply;
import com.study.springboot.service.ReplyService;

@Controller
public class ReplyController {
	@Autowired
	ReplyService rService;
	
	@GetMapping("/rinsert")
	public @ResponseBody boolean rinsert(Reply reply) {
		Reply res = rService.rinsert(reply);
		if(res == null)
			return false;
		else
			return true;
	}
}
