package com.study.springboot.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	/*
	 * 지금까지는 상태코드를 지정하기 휘해 HttpServletResponse의 setStatus()와 sendError()을 사용
	   문제점은 에러시 JSON이 아닌 HTML 결과로 응답함.
	   
	   정상, 비정상을 모두 JSON응답을 위한 ResponseEntity사용
	   - restFul하게 만들 때는 요구한 자원이 없을 때 404오류 반환(클라이언트측 오류<없는id를 넣었기 때문)
	     그래서 null과 null이 아닐 때를 나누어 처리가 필요
	     
	 * ResponseEntity : 결과 데이터와 HTTP 상태코드와 오류코드의 제어까지 직접 제어할 수 있는 클래스
	    					(HttpRequest에 대한 응답 데이터가 포함되어 있음)
	   - status : 응답에 대한 status코드
	   - header : header값 (요청/응답)에 대한 요구사항
	   - body : 메시지 body에 작성될 내용(요구사항의 내용)
	   
	 *  ResponseEntity 사용법
	   - status와 body를 이용
	     ResponseEntity.status(상태코드).body(객체)
	     
	     + 상태코드는 HttpStatus에 정의된 값 이용
	     
	     + 상태코드 OK와 body를 한번에 사용
	       ResponseEntity.ok(result)
	       
	     + body가 없을 때, build()사용
	       ResponseEntity.status(HttpStaus.NOT_FOUND).build()
	       
	     + body가 없고, status 대신 사용하는 메서드
	       noContent() : 204
	       badRequest() : 400
	       notFound() : 404
	 */
	
	@GetMapping("/{id}")
	public ResponseEntity<Menu> findByMenuId(@PathVariable(name="id") Long id) {
		Optional<Menu> menu = mService.findById(id);
		/*
		
		 */
		return menu.map(ResponseEntity::ok)
					.orElseGet(() -> ResponseEntity.notFound().build());
		// map() : Optional에 값이 있다면 상태 map() 실행한다
		// orElseGet : Optional에 값이 없다면 orElseGet() 실행한다
	}
	
	@PostMapping()
	public ResponseEntity<?> insertMenu(@RequestBody Menu menu) {
		System.out.println(menu);
		Menu res = mService.insertMenu(menu);
		return ResponseEntity.created(URI.create("/menu/" + res.getId())).build();
	}
	
	@PutMapping()
	public ResponseEntity<?> updateMenu(@RequestBody Menu menu) {
		System.out.println(menu);
		Menu result = mService.updateMenu(menu);
		return ResponseEntity.ok(result);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteMenu(@PathVariable(name="id") Long id) {
		System.out.println(id);
		mService.deleteMenu(id);
		return ResponseEntity.noContent().build(); // http 상태코드 204(No Content)
	}
}