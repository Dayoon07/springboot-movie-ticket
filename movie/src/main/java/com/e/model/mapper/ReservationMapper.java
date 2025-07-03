package com.e.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.e.model.dto.MovieReservationDto;

@Mapper
public interface ReservationMapper {
	List<String> findReservedSeatsByShowtimeId(Long showtimeId);
	List<MovieReservationDto> selectReservationMovie(String reservedcode);
	List<String> selectGetReservationMovieInfo(Long showtimeId);
	MovieReservationDto selectMyReservationMovieTicket(String reservationCode);
	List<MovieReservationDto> selectAllReservationMovieTicket();
	void cancelReservationMovieAndSeat(String reservationCode);
	void restoreAvailableSeats(String reservationCode, int seatCount);
}
