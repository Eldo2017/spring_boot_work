package com.study.shop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.study.shop.domain.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
	List<Cart> findByMemIdOrderById(String memId);
}