package com.e.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.e.model.entity.ShowtimeEntity;

@Repository
public interface ShowtimeRepo extends JpaRepository<ShowtimeEntity, Long> {

}
