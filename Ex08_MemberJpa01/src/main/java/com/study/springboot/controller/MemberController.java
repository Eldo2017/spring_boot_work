
package com.study.springboot.controller;

import java.time.LocalDate;
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
	public String insert(@RequestParam("username") String name, Model model) {
		Member member = Member.builder()
							  .username(name)
							  .createDate(LocalDate.now())
							  .build();
		Member result = mService.insert(member);
		model.addAttribute("member", result);
		return "insert";
	}
	
	@GetMapping("/select")
	public String select(@RequestParam("id") Long id, Model model) {
		Optional<Member> result= mService.select(id);
		// isPresent() : 데이터가 있는지(true) 없는지(false) 체크
		if(result.isPresent()) {
			model.addAttribute("member", result.get());  //result.get() -> Optional을 벗겨줌 (Member)
		} else {
			model.addAttribute("member", null);
		}
		return "select";
	}
	
	@GetMapping("/selectAll")
	public String selectAll(Model model) {
		model.addAttribute("members", mService.selectAll());
		return "selectAll";
	}
	
	@GetMapping("/delete")
    public String delete(@RequestParam("id") Long id) {
        mService.delete(id);        
        return "redirect:selectAll";
    }

    @GetMapping("/update")
    public String update(Member member, Model model) {
    		member.setCreateDate(LocalDate.now());
   		model.addAttribute("member", mService.update(member));
        return "update";
    }
}
