package com.e.model.vo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowtimeVo {
    private Long showtimeId;
    private Long movieId;
    private Long cinemaId;
    private LocalDate showDate;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer availableSeats;
    private Integer price;
    private String status;
    
    private MovieVo movie;
    private CinemaVo cinema;
}