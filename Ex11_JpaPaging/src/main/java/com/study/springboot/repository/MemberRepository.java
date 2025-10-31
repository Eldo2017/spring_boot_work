package com.study.springboot.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.springboot.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
	// findBy 뒤에 컬럼명을 붙여주면 이를 이용한 검색 가능
	List<Member> findByName(String name);

	// findByEmail 기능
	Member findByEmail(String email);

	List<Member> findByNameLike(String name);

	List<Member> findByNameLikeOrderByNameDesc(String name);

	List<Member> findByNameLike(String name, Sort sort);

}