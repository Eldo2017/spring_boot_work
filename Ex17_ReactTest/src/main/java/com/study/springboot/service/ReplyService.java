package com.study.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Reply;
import com.study.springboot.repository.ReplyRepository;

@Service
public class ReplyService {

	@Autowired
	ReplyRepository rRepository;

	public List<Reply> selectAll(Long bno) {
		return rRepository.findAllByRefBnoOrderByRnoDesc(bno);
	}

	public Reply rinsert(Reply reply) {
		return rRepository.save(reply);		
	}
}