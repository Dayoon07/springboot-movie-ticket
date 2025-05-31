package com.e.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatEntity {
	private Long seatId;
    private Long theaterId;
    private String rowName;
    private Integer seatNumber;
    private String seatType;
    private String status;
}
