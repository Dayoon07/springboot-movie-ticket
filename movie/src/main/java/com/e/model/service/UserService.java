package com.e.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e.model.mapper.UserMapper;
import com.e.model.repository.UserRepo;
import com.e.model.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserMapper userMmapper;
	
	public List<UserVo> selectAll() {
		return userMmapper.selectAll();
	}
	
}
