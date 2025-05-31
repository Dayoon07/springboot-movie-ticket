package com.e.model.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieEntity {
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
