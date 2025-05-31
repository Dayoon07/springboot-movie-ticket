package com.e.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheaterVo {
	private Long theaterId;
    private String theaterName;
    private Integer totalSeats;
    private String theaterType;
}
