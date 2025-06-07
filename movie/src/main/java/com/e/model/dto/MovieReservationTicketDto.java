package com.e.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieReservationTicketDto {
	private String cinema;
	private String date;
	private String movie;
	private int people;
	private List<String> seats;
	private String time;
	private int totalAmount;
}
