package com.e.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgeRatingVo {
	private Long ageRatingId;
    private String ageRatingName;
    private String description;
}
