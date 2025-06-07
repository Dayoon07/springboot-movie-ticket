package com.e.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReservationMapper {
	List<String> findReservedSeatsByShowtimeId(Long showtimeId);
}
