package com.study.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.springboot.domain.Board;
import com.study.springboot.repository.BoardRepository;


@RestController
@RequestMapping("/rest")
public class BoardRestController {
	@Autowired
	BoardRepository bRepository;
	
	@GetMapping("/boards")
	List<Board> all() {
		return bRepository.findAll();
	}
	// http://localhost:8080/rest/boards?title=개소리 집어쳐!
	@GetMapping(value = "/boards", params = "title")
	public List<Board> getByTitle(@RequestParam("title") String title) {
		return bRepository.findByTitle(title);
	}
	// http://localhost:8080/rest/boards?title=개소리 집어쳐!&content=무슨 님을 만난다는거야?
	@GetMapping(value = "/boards", params = {"title","content"})
	public List<Board> getByTitleAndContent(@RequestParam("title") String title,
											@RequestParam("content") String content) {
		return bRepository.findByTitleAndContent(title,content);
	}
	// http://localhost:8080/rest/boards/개소리 집어쳐!/content/무슨 님을 만난다는거야?
	@GetMapping("/boards/{title}/content/{content}")
	public List<Board> getByPath(@PathVariable("title") String title,
								@PathVariable("content") String content) {
		return bRepository.findByTitleAndContent(title, content);
	}
	// http://localhost:8080/rest/boards/1
	@GetMapping("/boards/{bno}")
	public Board getById(@PathVariable("bno") Long bno) {
		return bRepository.findById(bno).orElse(null);
	}
	// @PostMapping("/boards") -> ui에서 사용하는 경우
	@PostMapping("/boards")
	public Board createBoard(@RequestBody Board board) {
		board.setBno(null);
		return bRepository.save(board);
	}
	// @PutMapping("/boards/{bno}") -> 위와 마찬가지
	// 1. findById
	// 2. title or content 수정해서 DB에 저장하기
	@PutMapping("/boards/{bno}")
	public Board updateboard(@PathVariable("bno") Long bno, @RequestBody Board newBoard) {
		Optional<Board> opBoard = bRepository.findById(bno);
		
		if(opBoard.isPresent()) {
			Board board = opBoard.get();
			
			// title, content 수정하기
			if(newBoard.getTitle() != null && !newBoard.getTitle().isEmpty()) {
				board.setTitle(newBoard.getTitle());
			}
			if(newBoard.getContent() != null && !newBoard.getContent().isEmpty()) {
				board.setContent(newBoard.getContent());
			}
			
			return bRepository.save(board);
		} else {
			throw new IllegalArgumentException("게시글을 찾을 수 없습니다.");
		}
	}
	// @DeleteMapping("/boards/{bno}") -> 위의 2개와 마찬가지
	@DeleteMapping("/boards/{bno}")
	public String deleteBoard(@PathVariable("bno") Long bno) {
		Optional<Board> opBoard = bRepository.findById(bno);
		
		if(opBoard.isPresent()) {
			bRepository.deleteById(bno);
			return "삭제가 완료되었습니다.";
		} else {
			return "삭제 실패 : 게시글을 찾을 수 없습니다.";
		}
	}
}
