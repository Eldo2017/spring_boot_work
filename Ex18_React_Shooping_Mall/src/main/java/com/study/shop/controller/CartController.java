package com.study.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.shop.domain.Cart;
import com.study.shop.service.CartService;

@RestController
@RequestMapping("/react")
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@PostMapping("/addCart")
	public String addCart(@RequestBody Cart cart) {
		boolean result = cartService.addCart(cart);
		if(result) {
			return "ok";
		} else {
			return "fail";
		}
	}
	
	@GetMapping("/getCart")
	public List<Cart> getCart(@RequestParam(value="memId") String memId) {
		return cartService.getCart(memId);
	}
}