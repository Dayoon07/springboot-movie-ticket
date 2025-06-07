package com.e.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.e.model.entity.UserEntity;
import com.e.model.mapper.UserMapper;
import com.e.model.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public UserService() {
	}
	
	public void signup(String name, String email, String password, String tel) {
		UserEntity entity = UserEntity.builder()
				.name(name)
				.email(email)
				.password(passwordEncoder.encode(password))
				.phone(tel)
				.build();
		System.out.println(entity);
		userRepo.save(entity);
	}
	
}
