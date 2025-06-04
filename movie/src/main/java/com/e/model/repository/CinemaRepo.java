package com.e.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e.model.entity.CinemaEntity;

@Repository
public interface CinemaRepo extends JpaRepository<CinemaEntity, Long> {

}
