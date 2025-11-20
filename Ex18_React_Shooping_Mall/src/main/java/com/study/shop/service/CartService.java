package com.study.shop.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.shop.domain.Cart;
import com.study.shop.repository.CartRepository;

@Service
public class CartService {
	
	@Autowired
	CartRepository cartRepository;

	public boolean addCart(Cart cart) {
		List<Cart> result = cartRepository.findByMemIdOrderById(cart.getMemId());

		try {
			for(Cart c : result) {
				if(c.getId().equals(cart.getId())) {
					c.setCount(c.getCount() + cart.getCount());
					cartRepository.save(c);
					return true;
				} 
			}
			cartRepository.save(cart);
			return true;
		} catch(Exception e) {
			return false;
		}
	}

	public List<Cart> getCart(String memId) {
		return cartRepository.findByMemIdOrderById(memId);
	}
}