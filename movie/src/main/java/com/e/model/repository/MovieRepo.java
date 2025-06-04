package com.e.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e.model.entity.MovieEntity;

@Repository
public interface MovieRepo extends JpaRepository<MovieEntity, Long> {

}
