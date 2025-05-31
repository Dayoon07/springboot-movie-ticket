package com.e.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatVo {
	private Long seatId;
    private Long theaterId;
    private String rowName;
    private Integer seatNumber;
    private String seatType;
    private String status;
}
