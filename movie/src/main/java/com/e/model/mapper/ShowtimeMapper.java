package com.e.model.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShowtimeMapper {
	void updateReservationMovieTicketSeat(Long people, Long showtimeId);
}
