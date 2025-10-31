package com.study.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Member;
import com.study.springboot.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	MemberRepository mRepository;
	
	public Page<Member> selectByNameLike(String name, Pageable pageable) {
		return mRepository.findByNameLike(name, pageable);
	}
}