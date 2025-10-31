package com.study.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.springboot.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
	// findBy �ڿ� �÷����� �ٿ��ָ� �̸� �̿��� �˻� ����
	List<Member> findByName(String name);

	// findByEmail ���
	Member findByEmail(String email);

	List<Member> findByNameLike(String name);

	List<Member> findByNameLikeOrderByNameDesc(String name);

	List<Member> findByNameLike(String name, Sort sort);

}