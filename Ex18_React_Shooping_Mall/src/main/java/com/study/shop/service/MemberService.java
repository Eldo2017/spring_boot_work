package com.study.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.shop.domain.Member;
import com.study.shop.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	MemberRepository memberRepository;

	public boolean emailCheck(String email) {
		return memberRepository.existsById(email);
	}

	public void insertMember(Member member) {
		memberRepository.save(member);
	}

	public Member login(Member member) {
		return memberRepository.findByEmailAndPassword(member.getEmail(), member.getPassword());
	}

	
}