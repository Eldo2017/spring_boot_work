package com.study.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Member;
import com.study.springboot.repository.MemberRepository;

@Service
public class MemberService {
	@Autowired
	MemberRepository mRepository;
	
	public void insert() {
		Member user;
		user = new Member("Demons3620@naver.com","±èµÎÇÑ");
		mRepository.save(user);
		user = new Member("Vail9915@naver.com","°­¾Æ±¸");
		mRepository.save(user);
		user = new Member("Destream1623@naver.com","À±°¥Ä¡");
		mRepository.save(user);
		user = new Member("Juuga4713@naver.com","ÀÌÁ¤Àç");
		mRepository.save(user);
		user = new Member("Glare6237@naver.com","±è¹«¿Á");
		mRepository.save(user);
		user = new Member("Gazer8255@naver.com","¹®¿µÃ¶");
		mRepository.save(user);
		user = new Member("Glare2_7154@naver.com","±è¿µÅÂ");
		mRepository.save(user);
		user = new Member("Regad2259@naver.com","½Å¿µ±Õ");
		mRepository.save(user);
		user = new Member("RegadOmega16@naver.com","È«¸¸±æ");
		mRepository.save(user);
		user = new Member("Dread3645@naver.com","°í°æÁÖ");
		mRepository.save(user);
		user = new Member("Dorado6659@naver.com","±è°üÃ¶");
		mRepository.save(user);
		user = new Member("Eldo8845@naver.com","±è»ï¼ö");
		mRepository.save(user);
	}

	public List<Member> selectAll() {
		return mRepository.findAll();
	}
	
	public Optional<Member> selectById(Long id) {
		return mRepository.findById(id);
	}
}