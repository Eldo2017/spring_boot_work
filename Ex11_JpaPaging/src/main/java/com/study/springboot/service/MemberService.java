package com.study.springboot.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Member;
import com.study.springboot.repository.MemberRepository;

import com.study.springboot.domain.Member;

@Service
public class MemberService {
	@Autowired
	MemberRepository mRepository;
	
	public void insert() {
		Member user;
		user = new Member("test1@tjoeun.com", "��μ�");
		mRepository.save(user);
		user = new Member("test2@tjoeun.com", "�̼���");
		mRepository.save(user);
		user = new Member("test3@tjoeun.com", "������");
		mRepository.save(user);
		user = new Member("test4@tjoeun.com", "������");
		mRepository.save(user);
		user = new Member("test5@tjoeun.com", "������");
		mRepository.save(user);
		user = new Member("test6@tjoeun.com", "������");
		mRepository.save(user);
		user = new Member("test7@tjoeun.com", "������");
		mRepository.save(user);
		user = new Member("test8@tjoeun.com", "���Ƹ�");
		mRepository.save(user);
		user = new Member("test9@tjoeun.com", "�����");
		mRepository.save(user);
	}

	public List<Member> selectAll() {
		return mRepository.findAll();
	}

	public Optional<Member> selectById(Long id) {
		return mRepository.findById(id);
	}

	public List<Member> selectByName(String name) {
		return mRepository.findByName(name);
	}
	
	public Member selectByEmail(String email) {
		return mRepository.findByEmail(email);
	}

	public List<Member> selectByNameLike(String name) {
		return mRepository.findByNameLike(name);
	}

	public List<Member> selectByNameLikeNameDesc(String name) {
		return mRepository.findByNameLikeOrderByNameDesc(name);
	}

	public List<Member> selectByNameLikeOrder(String name, Sort sort) {
		return mRepository.findByNameLike(name,sort);
	}
}