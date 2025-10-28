package com.study.springboot.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.study.springboot.domain.Board;

@Mapper
public interface BoardRepository {
	public List<Board> list();
	public Board detailBoard(String boardno);
	public int totalRecord();
	public int writeBoard(Board b);
	public int deleteBoard(String boardno);
}