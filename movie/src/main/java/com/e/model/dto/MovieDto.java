package com.e.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDto {
	private Long movieId;
	private String title;
	private String posterImageUrl;
	private String genre;
	private String ratingAge;
}
