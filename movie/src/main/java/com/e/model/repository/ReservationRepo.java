package com.e.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e.model.entity.ReservationEntity;

@Repository
public interface ReservationRepo extends JpaRepository<ReservationEntity, Long> {
	
}
