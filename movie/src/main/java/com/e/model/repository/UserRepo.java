package com.e.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e.model.entity.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long> {
	UserEntity findByNameAndPassword(String name, String password);
	List<UserEntity> findByName(String name);
}
