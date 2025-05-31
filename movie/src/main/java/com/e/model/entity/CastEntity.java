package com.e.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CastEntity {
	private Long castId;
    private Long movieId;
    private Long personId;
    private String role;
}
