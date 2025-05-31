package com.e.model.vo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieVo {
	private Long movieId;
    private String title;
    private LocalDateTime releaseDate;
    private String posterImageUrl;
    private Long ratingId;
    private Long genreId;
    private Long ageRatingId;
    private String status;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
