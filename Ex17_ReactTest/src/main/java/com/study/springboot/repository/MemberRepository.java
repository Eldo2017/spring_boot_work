package com.study.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.springboot.domain.Member;
import com.study.springboot.dto.UserDto;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

}