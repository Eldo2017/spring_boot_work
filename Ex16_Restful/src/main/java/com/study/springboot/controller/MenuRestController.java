package com.study.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.study.springboot.domain.Menu;
import com.study.springboot.domain.Taste;
import com.study.springboot.domain.Type;
import com.study.springboot.service.MenuService;

@RestController
@RequestMapping("/menu")
public class MenuRestController {
	@Autowired
	MenuService mService;
	
	@GetMapping
	public List<Menu> menuAllList() {
		return mService.menuAllList();
	}
	
	@GetMapping("/type/{type}")
	public List<Menu> findByType(@PathVariable(name="type") Type type) {
		return mService.findByType(type);
	}
	
	@GetMapping("/type/{type}/taste/{taste}")
	public List<Menu> findByTypeAndTaste(@PathVariable(name="type") Type type, 
										@PathVariable(name="taste") Taste taste) {
		return mService.findByTypeAndTaste(type, taste);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Menu> findByMenuId(@PathVariable(name="id") Long id) {
		Optional<Menu> menu = mService.findById(id);
		return menu.map(ResponseEntity::ok)
					.orElseGet(() -> ResponseEntity.notFound().build());
	}
}