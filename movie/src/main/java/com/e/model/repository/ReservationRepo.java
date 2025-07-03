package com.e.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e.model.entity.ReservationEntity;
import com.e.model.entity.ShowtimeEntity;

@Repository
public interface ReservationRepo extends JpaRepository<ReservationEntity, Long> {
	boolean existsByShowtimeAndReservedSeatsContaining(ShowtimeEntity showtime, String seats);
	List<ReservationEntity> findByShowtime(ShowtimeEntity showtime);
}
