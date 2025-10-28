package com.study.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.domain.Board;
import com.study.springboot.service.BoardService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	/*
	 * 요청 처리 후 응답페이지로 포워딩 또는 url재 요청시 응답 데이터를 담는 방법
	   1. Model 객체
	      포워딩할 뷰로 전달하고자 하는 데이터르 맵형식<key-value>로 담을 수 있는 영역
	      requestScope임.
	      ** 단, setAttribute가 아니라 addAttribute메소드 이용
	      
	   2. ModelAndView 객체
	      Model은 데이터를 맵형식<key-value>로 담을 수 있는 영역
	      View는 응답뷰에 대한 정보를 담을 수 있는 공간
	 */
	@RequestMapping("/")
	public String root(Model model) {
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String listPage(Model model) {
		// List<Board> list = boardService.list();
		// int reuslt = boardService.totalRecord();
		model.addAttribute("list", boardService.list());
		model.addAttribute("totalRecord", boardService.totalRecord());
		return "list";
	}
	
	/*
	 * 요청시 전달한 값(파라메터)를 받는 방법
	   1. HttpServletRequest를 이용하는 방법
	   	  : 메서드의 매개변수에 넣는 방법
	   	  ex)
	   	  @RequestMapping("/detail")
	   	  public String view(HtteServletRequest request) {
	   	  	int bno = Integer.parseInt(request.getParameter("boardno"));
	   	  }
	   	  
	   2. @RequestParam 어노테이션을 사용하는 방법
	   	  : 메서드 위에 어노테이션을 넣는 방법
	   	  ex)
	   	  @RequestMapping("/detail")
	   	  public String view(@RequestParam(value="boardno") int bno,
	   	  					 @RequestParam(value="writer", defaultValue="홍길동") String name){
	   	  }	
	   
	   3. @ModelAttribute 어노테이션을 사용하는 방법
	   	  : 주로 객체를 받을 때 사용
	   	    요청시 전달값의 키값(name값)을 bean클래스에 담고자하는 필드명으로 작성
	   	    
	   	    스프링컨테이너가 해당 객체를 기본생성자로 생성 후 setter메소드를 찾아(반드시 빈 생성자 있어야함. setter메소드도 있어야함)
	   	    요청시 전달값을 해당 필드에 담아주는 내부적인 원리
	   	    
	   	    ** 반드시 name속성값(키값)과 담고자하는 필드명이 동일해야 함
	   	    ex)
	   	    @RequestMapping("/write")
	   	    public String write(@ModelAttribute("form") Board b) {
	   	    		String title = b.getTitle();
	   	    }
	   	    
	   4. 커맨드 객체 방식
	   	  : 객체를 받을 때 사용
	   	    요청시 전달한값의 키값(name값)을 bean클래스에 담고자하는 필드명으로 작성
	   	    
	   	    스프링컨테이너가 해당 객체를 기본생성자로 생성 후 setter메소드를 찾아(반드시 빈 생성자 있어야함. setter메소드도 있어야함)
	   	    요청시 전달값을 해당 필드에 담아주는 내부적인 원리
	   	    
	   	    ** 반드시 name속성값(키값)과 담고자하는 필드명이 동일해야 함
	   	    
	   	 ex)
	   	 @RequestMapping("/write")
	   	 public String write(Board b) {
	   	 	String title = b.getTitle();
	   	 }      
	 */
	@RequestMapping("/detail")
	public String view(HttpServletRequest request, Model model) {
		String sBoardno = request.getParameter("boardno");
		model.addAttribute("detailBoard", boardService.detailBoard(sBoardno));
		return "detail";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		return "writeForm";
	}
	
	@PostMapping("/write")
	public String write(Board b) {
		System.out.println(b.getTitle());
		boardService.insertBoard(b);
		return "redirect:list";
	}
}