package com.e.model.vo;

import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieVo {
    private Long movieId;
    private String title;
    private LocalDate releaseDate;
    private String posterImageUrl;
    private String genre;
    private String rating;
    private String ageRating;
    private String synopsis;
    private Integer duration;
    private String language;
    private String country;
    private String releaseType;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}