package com.e.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservedSeatEntity {
	private Long reservedSeatId;
    private Long reservationId;
    private Long seatId;
    private Long showtimeId;
}
