package com.e.model.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationEntity {
	private Long reservationId;
	private Long userId;
	private Long showtimeId;
	private LocalDateTime reservationDate;
	private int totalAmount;
	private String reservationStatus;
	private String reservationCode;
}
