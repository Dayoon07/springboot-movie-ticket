package com.e.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailEntity {
	private Long movieId;
    private String synopsis;
    private Integer duration;
    private String language;
    private String country;
    private String releaseType;
}
