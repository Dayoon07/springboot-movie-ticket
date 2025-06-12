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
	private Long userId;	// 관리자 계정
	private Long movieId;
	private String movieTitle;
	private String moviePosterImageUrl;
	private Long showtimeId;
	private String cinemaName;
	private List<String> seats;
	private Long people;
	private Integer price;
	private Integer totalPrice;
	private String paymentMethod;
}
