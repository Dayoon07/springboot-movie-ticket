package com.e.model.vo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieVo {
    private Long movieId;
    private String title;
    private String posterImageUrl;
    private String genre;
    private Integer duration;
    private String ratingAge;
}