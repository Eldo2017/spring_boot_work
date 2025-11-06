package com.study.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.springboot.domain.Member;
import com.study.springboot.dto.ResponseDto;
import com.study.springboot.dto.UserDto;
import com.study.springboot.service.MemberRestService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/rest")
@Slf4j
public class MemberRestController {
	@Autowired
	MemberRestService restService;
	
	@GetMapping("/test")
	public String test() {
		log.info("test");
		return "test용";
	}
	
	@GetMapping("/user/{id}")
	public String getUser(@PathVariable("id") String id) {
		log.info("id : ", id);
		return "ok : " + id;
	}
	
	/*
	@PostMapping("/userdto")
	public UserDto saveUserDto(@RequestBody UserDto userDto) {
		Member m = restService.saveUserDto(userDto);
		UserDto reDto = new UserDto(m);
		
		
		UserDto reDto = new UserDto(restService.saveUserDto(userDto));
		return reDto;
		
		
		return new UserDto(restService.saveUserDto(userDto));
	}
	*/
	
	@PostMapping("/userdto")
	public ResponseDto saveUserDto(@RequestBody UserDto userDto) {
		Member m = restService.saveUserDto(userDto);
		
		ResponseDto reDto = new ResponseDto();
		if(m.getId() != null) {
			reDto.setMessage("OK");
			return reDto;
		}
		
		reDto.setMessage("Fail");
		return reDto;
	}
	
	@GetMapping("/userdto")
	public UserDto getUserDto(@RequestParam("id") String id) {
		return restService.getUserById(id);
	}
	
	@GetMapping("/userdto/{id}")
	public UserDto getUserDto2(@PathVariable("id") String id) {
		return restService.getUserById(id);
	}
	
	@GetMapping("/userall")
	public List<Member> getUserAll() {
		return restService.getUserAll();
	}
	
	@GetMapping("/userdtoall")
	public List<UserDto> getUserDtoAll() {
		return restService.getUserDtoAll();
	}
}