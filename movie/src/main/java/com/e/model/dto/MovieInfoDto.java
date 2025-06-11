package com.e.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieInfoDto {
	private Long showtimeId;
	private String showDate;
	private String startTime;
	private String endTime;
	private String cinemaName;
	private String cinemaType;
	private int availableSeats;
	private int price;
}
