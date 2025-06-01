package com.e.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.e.model.entity.UserEntity;
import com.e.model.repository.UserRepo;
import com.e.model.service.UserService;
import com.e.model.vo.UserVo;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(path = "/api")
public class RestMainController {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<String> index() {
		return ResponseEntity.ok("hello world");
	}
	
	@GetMapping("/find/user/all")
	public ResponseEntity<List<UserEntity>> find() {
		return ResponseEntity.ok(userRepo.findAll());
	}
	
	@GetMapping("/select/user/all")
	public ResponseEntity<List<UserVo>> find2() {
		return ResponseEntity.ok(userService.selectAll());
	}

}
