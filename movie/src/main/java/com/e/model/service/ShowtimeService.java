package com.e.model.service;

import org.springframework.stereotype.Service;

import com.e.model.mapper.ShowtimeMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShowtimeService {

	private final ShowtimeMapper mapper;
	
	public void updateReservationMovieTicketSeat(Long people, Long showtimeId) {
		mapper.updateReservationMovieTicketSeat(people, showtimeId);
	}

}
