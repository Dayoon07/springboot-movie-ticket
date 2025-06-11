package com.e.model.vo;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationVo {
    private Long reservationId;
    private Long userId;
    private Long showtimeId;
    private String reservationMoviePosterUrl;
    private LocalDateTime reservationDate;
    private Integer totalAmount;
    private String reservationStatus;
    private String reservationCode;
    private String reservedSeats;
    private String paymentMethod;
    private LocalDateTime paymentDate;
    private String transactionId;
    
    private UserVo user;
    private ShowtimeVo showtime;
}