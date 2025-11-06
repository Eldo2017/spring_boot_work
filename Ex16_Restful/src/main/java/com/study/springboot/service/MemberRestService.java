package com.study.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Member;
import com.study.springboot.dto.UserDto;
import com.study.springboot.repository.MemberRepository;

@Service
public class MemberRestService {
	@Autowired
	MemberRepository repository;

	public Member saveUserDto(UserDto userDto) {
		Member member = new Member();
		member.setId(userDto.getId());
		member.setPassword("regad01");
		member.setName(userDto.getName());
		return repository.save(member);
	}

	public UserDto getUserById(String id) {
		return new UserDto(repository.findById(id).get());
	}

	public List<Member> getUserAll() {
		return repository.findAll();
	}
	
	public List<UserDto> getUserDtoAll() {
		List<UserDto> ulist = new ArrayList<>();
		for(Member m : repository.findAll()) {
			ulist.add(new UserDto(m));
		}
		return ulist;
	}
}
