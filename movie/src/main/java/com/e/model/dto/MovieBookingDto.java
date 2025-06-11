package com.e.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieBookingDto {

	private Long movieId; // 영화 PK값
	private String movieTitle; // 영화 이름
	private String posterImageUrl; // 영화 포스터
	private String ratingAge; // 관람 연령
	private String genre; // 장르
	private int duration; // 상영 시간(분)

	// 상영시간표 정보
	private Long showtimeId; // 상영시간표 ID
	private String startTime; // 영화 시작 시간
	private int availableSeats; // 남은 좌석 수
	private int price; // 티켓 가격

	// 상영관 정보
	private String cinemaName; // 상영관 이름
	private String cinemaType; // 상영관 타입

}
