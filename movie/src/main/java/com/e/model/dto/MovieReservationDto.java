package com.e.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieReservationDto {
	private String reservationCode;
	private String customerName;
	private String phone;
	private String movieTitle;
	private String cinemaName;
	private String showtime;
	private String reservedSeats;
	private String totalAmount;
	private String reservationStatus;
}
