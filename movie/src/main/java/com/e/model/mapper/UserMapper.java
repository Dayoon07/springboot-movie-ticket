package com.e.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.e.model.vo.UserVo;

@Mapper
public interface UserMapper {

	List<UserVo> selectAll();
	
}
