package com.e.model.service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.e.model.mapper.ReservationMapper;

@Service
public class ReservationService {
	
	@Autowired
	private ReservationMapper reservationMapper;
	
	public List<String> getOccupiedSeats(Long showtimeId) {
        List<String> seatStrings = reservationMapper.findReservedSeatsByShowtimeId(showtimeId);
        
        return seatStrings.stream()
                .filter(Objects::nonNull)
                .flatMap(s -> Arrays.stream(s.split(",")))
                .distinct()
                .collect(Collectors.toList());
    }
}
