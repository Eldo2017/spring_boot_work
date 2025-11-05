package com.study.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.study.springboot.domain.Board;
import com.study.springboot.domain.Member;
import com.study.springboot.service.BoardService;
import com.study.springboot.service.ReplyService;

import jakarta.servlet.http.HttpSession;

@Controller
@SessionAttributes("loginUser")
public class BoardController {

	@Autowired
	BoardService bService;
	
	@Autowired
	ReplyService rService;
	
	@GetMapping("list")
	public String list(@RequestParam(value="nowPage", defaultValue="0") int nowPage, Model model) {
		Page<Board> list = bService.list(PageRequest.of(nowPage, 2, Sort.by(Sort.Direction.DESC, "bno")));
		
		int pagePerBlock = 2;  // [1]~[5] 
		/*
		int endPage = nowPage + pagePerBlock;
		if(list.getTotalPages() < endPage) {
			endPage = list.getTotalPages();
		}
		*/
		int endPage = Math.min(list.getTotalPages(), nowPage + pagePerBlock);
								
		model.addAttribute("boardPage", list);
		model.addAttribute("endPage", endPage);
		model.addAttribute("nowPage", nowPage);  // 선택(안넘겨주면 사용시 boardPage.number 를 이용하면 됨)
		return "board/list";
	}
	
	@GetMapping("/insertForm")
	public String insertForm(@SessionAttribute(value="loginUser", required=false) Member loginUser , Model model) {
		model.addAttribute("loginUser", loginUser);
		return "board/insertForm";
	}
	
	@PostMapping("/insert")
	public String insert(Board board) {
		bService.insert(board);
		return "redirect:list";
	}
	
	@GetMapping("/detailForm")
	public String detailForm(@RequestParam("bno") Long bno, HttpSession session ,Model model) {
		//Board board= bService.selectDetail(bno).get();
		//List<Reply> replyList = rService.selectAll(bno);
		model.addAttribute("board", bService.selectDetail(bno).get());
		model.addAttribute("reply", rService.selectAll(bno));
		
		session.setAttribute("boardDetailUrl", "/detailForm?bno=" + bno);
		return "board/detailForm";
	}
	
	@PostMapping("/update")
	public String update(Board board) {
		System.out.println("bno : " + board.getBno());
		Board r = bService.update(board);
		System.out.println("결과 title : " + r.getTitle());
		return "redirect:list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("bno") Long bno) {
		bService.delete(bno);
		return "redirect:list";
	}
}