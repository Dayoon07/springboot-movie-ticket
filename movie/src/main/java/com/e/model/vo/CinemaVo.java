package com.e.model.vo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CinemaVo {
    private Long cinemaId;
    private String cinemaName;
    private Long totalSeats;
    private String cinemaType;
    private String seatLayout;
}