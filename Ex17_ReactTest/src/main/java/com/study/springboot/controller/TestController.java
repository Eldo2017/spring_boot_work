package com.study.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.springboot.domain.Menu;
import com.study.springboot.service.MenuService;

@RestController
@RequestMapping("/api")
public class TestController {
	// @CrossOrigin(origins="http://localhost:3000")
	@Autowired
	MenuService mService;
	
	@GetMapping("/test")
	public String Doohan() {
		return "나 김두한이다";
	}
	
	@GetMapping("/menuall")
	public List<Menu> menuAllList() {
		return mService.menuAllList();
	}
	
	@PostMapping("/addmenu")
	public Menu addMenu(@RequestBody Menu m) {
		return mService.insertMenu(m);
	}
}
