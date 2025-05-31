package com.e.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheaterEntity {
	private Long theaterId;
    private String theaterName;
    private Integer totalSeats;
    private String theaterType;
}
