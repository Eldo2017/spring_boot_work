package com.study.springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Board;
import com.study.springboot.repository.BoardRepository;


@Service
public class BoardService {
	
	@Autowired
	BoardRepository bRepository;
	
	public Page<Board> list(Pageable pageable) {
		return bRepository.findAll(pageable);
	}

	public Board insert(Board board) {
		return bRepository.save(board);		
	}
	/*
	 * Optional.map() : Optional에 값이 있을 때만 주어진 람다 함수를 실행하여
	 					결과를 반환
	 					만약 Optional에 값이 없으면 Optional.empty()반환
	 */
	public Optional<Board> selectDetail(Long bno) {
		return bRepository.findById(bno)
						  .map(board -> {
							  board.setCount(board.getCount() + 1);
							  return bRepository.save(board);
						  });
	}

	public Board update(Board board) {
		Board result = bRepository.findById(board.getBno()).get();
		result.setTitle(board.getTitle());
		result.setContent(board.getContent());
		
		return bRepository.save(result);
	}

	public void delete(Long bno) {
		bRepository.deleteById(bno);
	}
}