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
	private Long userId;
	private Long showtimeId;
	private String movie;
	private String poster;
    private String date;
    private String time;
    private int people;
    private List<String> seats;
    private String cinema;
    private String paymentMethod;
    private int totalAmount;
}
