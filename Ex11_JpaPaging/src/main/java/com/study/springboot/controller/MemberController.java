package com.study.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	@GetMapping("/selectByNameLike")
	public String selectByNameLike(@RequestParam("name") String search,
									@RequestParam("page") int page,
									Model model) 
	{
		System.out.println(search);
		System.out.println(page);
		String name = search + "%";
		/*
		 * Pageable �������̽�
		   : Spring ������ Pagination�� �����ϴ� Pageable �������̽��� �����Ѵ�
		   - getPageNumber() : ���� ������ ��ȣ ��ȯ(0����)
		   - getPageSize : �� ������ �� �ִ� �׸� �� ��ȯ
		   - getOffset() : ���� ������ ���� ��ġ ��ȯ
		   - getSort() : ���� ���� ��ȯ
		   - next() : ���� ������ ���� ��ȯ
		   - previous() : ���� ������ ���� ��ȯ
		   
		 * PageRequest Ŭ����
		   : Spring Data JPA���� �����ϴ� Pageable ����ü �� �ϳ���, ������ ������ �����Ѵ�
		   - page : ��ȸ�� ������ ��ȣ(0����)
		   - size : �� �������� �ִ� �׸� ��
		   - sort : ���� ����(���� ����)
		   - direction : ���� ����(ASC, DESC)
		   - properties : ���� ��� �Ӽ���
		   
		   > ������
		   PageRequest(int page, int size)
		   PageRequest(int page, int size, Sort sort)
		   PageRequest(int page, int size, Sort.Direction direction, String... properties)
		 */
		
		int nPage = page - 1;
		Sort sort = Sort.by(Sort.Order.desc("name"));
		
		
		/*
		Pageable pageable = PageRequest.ofSize(10)
										.withPage(nPage)
										.withSort(sort);
		*/
		
		Pageable pageable = PageRequest.of(nPage, 10, sort);
		Page<Member> res = mService.selectByNameLike(name, pageable);
		
		List<Member> content = res.getContent(); // ���� ��ü�� ��� List<Member>�� ��ȯ�����ش�
		long totalElements = res.getTotalElements(); // �� ���ڵ� ��
		int totalPages = res.getTotalPages(); // �� ������ ��
		int size = res.getSize(); // 1������ �� �� ���ڵ� ��
		int pPage = res.getNumber() + 1; // ���� ������(0������ => �׷��� +1�� �ؾ� 1������ �����Ѵ�)
		int ePage = res.getNumberOfElements(); // ���� ������ �� ���ڵ� ��
		
		model.addAttribute("members", content);
		model.addAttribute("totalElements", totalElements);
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("size", size);
		model.addAttribute("pPage", pPage);
		model.addAttribute("ePage", ePage);
		
		return "selectPage";
	}
}