package com.study.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Board;
import com.study.springboot.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardRepository boardDao;
	
	@Override
	public List<Board> list() {
		return boardDao.list();
	}

	@Override
	public Board detailBoard(String boardno) {
		return boardDao.detailBoard(boardno);
	}

	@Override
	public int totalRecord() {
		return boardDao.totalRecord();
	}

	@Override
	public int insertBoard(Board b) {
		return boardDao.writeBoard(b);
	}

	@Override
	public int deleteBoard(String boardno) {
		return boardDao.deleteBoard(boardno);
	}
}