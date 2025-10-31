package com.study.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
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
		return "insert";
	}
	
	@GetMapping("/selectAll")
	public String selectAll(Model model) {
		List<Member> list = mService.selectAll();
		model.addAttribute("mList", list);
		model.addAttribute("title", "All");
		return "select_list";
	}
	
	@GetMapping("/selectById")
	public String selectById(@RequestParam("id") Long id, Model model) {
		System.out.println(id);
		Optional<Member> member = mService.selectById(id);
		if(member.isPresent()) {
			model.addAttribute("member", member.get());
		} else {
			model.addAttribute("member", null);
		}
		model.addAttribute("title", "ID");
		return "select_one";
	}
	
	@GetMapping("/selectByName")
	public String selectByName(@RequestParam("name") String name, Model model) {
		List<Member> list = mService.selectByName(name);
		model.addAttribute("mList", list);
		model.addAttribute("title", "Name");
		return "select_list";
	}

	@GetMapping("/selectByEmail")
	public String selectByEmail(@RequestParam("email") String email, Model model) {
		Member member = mService.selectByEmail(email);
		model.addAttribute("member", member);
		model.addAttribute("title", "Email");
		return "select_one";
	}
	
	@GetMapping("/selectByNameLike")
	public String selectByNameLike(@RequestParam("name") String name, Model model) {
		name= "%" + name + "%";
		List<Member> list = mService.selectByNameLike(name);
		model.addAttribute("mList", list);
		model.addAttribute("title", "NameLike");
		return "select_list";
	}
	
	@GetMapping("/selectByNameLikeNameDesc")
	public String selectByNameLikeNameDesc(@RequestParam("name") String name, Model model) {
		name= "%" + name + "%";
		List<Member> list = mService.selectByNameLikeNameDesc(name);
		model.addAttribute("mList", list);
		model.addAttribute("title", "NameLikeNameDesc");
		return "select_list";
	}
	
	@GetMapping("selectByNameOrder")
	public String selectByNameOrder(@RequestParam("name") String name, Model model) {
		name= "%" + name + "%";
		/*
		 * Sort / Sort.order
		   - spring Framework의 일부, 데이터 정렬을 지정하는데 사용한다
		   - sort 클래스는 하나 이상의 Sort.Order 객체를 가진다
		     ex) 하나라면
		         Sort sort = Sort.by(Sort.Order("컬럼명"));
		         
		         하나 이상이면
		         Sort sort = Sort.by(
		         			 Sort.Order("컬럼명"),
		         			 Sort.Order("컬럼명"),
		         			 			...
		         			 )
		 */
		Sort sort = Sort.by(Sort.Order.desc("name"),
							Sort.Order.desc("email"));
		List<Member> list = mService.selectByNameLikeOrder(name,sort);
		model.addAttribute("mList", list);
		model.addAttribute("title", "NameOrder");
		return "select_list";
	}
}