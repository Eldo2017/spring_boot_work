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
	 * ��û ó�� �� ������������ ������ �Ǵ� url�� ��û�� ���� �����͸� ��� ���
	   1. Model ��ü
	      �������� ��� �����ϰ��� �ϴ� �����͸� ������<key-value>�� ���� �� �ִ� ����
	      requestScope��.
	      ** ��, setAttribute�� �ƴ϶� addAttribute�޼ҵ� �̿�
	      
	   2. ModelAndView ��ü
	      Model�� �����͸� ������<key-value>�� ���� �� �ִ� ����
	      View�� ����信 ���� ������ ���� �� �ִ� ����
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
	 * ��û�� ������ ��(�Ķ����)�� �޴� ���
	   1. HttpServletRequest�� �̿��ϴ� ���
	   	  : �޼����� �Ű������� �ִ� ���
	   	  ex)
	   	  @RequestMapping("/detail")
	   	  public String view(HtteServletRequest request) {
	   	  	int bno = Integer.parseInt(request.getParameter("boardno"));
	   	  }
	   	  
	   2. @RequestParam ������̼��� ����ϴ� ���
	   	  : �޼��� ���� ������̼��� �ִ� ���
	   	  ex)
	   	  @RequestMapping("/detail")
	   	  public String view(@RequestParam(value="boardno") int bno,
	   	  					 @RequestParam(value="writer", defaultValue="ȫ�浿") String name){
	   	  }	
	   
	   3. @ModelAttribute ������̼��� ����ϴ� ���
	   	  : �ַ� ��ü�� ���� �� ���
	   	    ��û�� ���ް��� Ű��(name��)�� beanŬ������ ������ϴ� �ʵ������ �ۼ�
	   	    
	   	    �����������̳ʰ� �ش� ��ü�� �⺻�����ڷ� ���� �� setter�޼ҵ带 ã��(�ݵ�� �� ������ �־����. setter�޼ҵ嵵 �־����)
	   	    ��û�� ���ް��� �ش� �ʵ忡 ����ִ� �������� ����
	   	    
	   	    ** �ݵ�� name�Ӽ���(Ű��)�� ������ϴ� �ʵ���� �����ؾ� ��
	   	    ex)
	   	    @RequestMapping("/write")
	   	    public String write(@ModelAttribute("form") Board b) {
	   	    		String title = b.getTitle();
	   	    }
	   	    
	   4. Ŀ�ǵ� ��ü ���
	   	  : ��ü�� ���� �� ���
	   	    ��û�� �����Ѱ��� Ű��(name��)�� beanŬ������ ������ϴ� �ʵ������ �ۼ�
	   	    
	   	    �����������̳ʰ� �ش� ��ü�� �⺻�����ڷ� ���� �� setter�޼ҵ带 ã��(�ݵ�� �� ������ �־����. setter�޼ҵ嵵 �־����)
	   	    ��û�� ���ް��� �ش� �ʵ忡 ����ִ� �������� ����
	   	    
	   	    ** �ݵ�� name�Ӽ���(Ű��)�� ������ϴ� �ʵ���� �����ؾ� ��
	   	    
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