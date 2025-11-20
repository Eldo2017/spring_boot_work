package com.study.shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.shop.domain.Member;

import lombok.NonNull;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

	Member findByEmailAndPassword(String email, @NonNull String password);
    
}