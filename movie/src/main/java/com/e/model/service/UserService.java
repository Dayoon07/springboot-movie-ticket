package com.e.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e.model.mapper.UserMapper;
import com.e.model.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private UserMapper userMapper;
	
	public UserService() {
	}
	
}
