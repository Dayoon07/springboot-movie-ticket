package com.e.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MOVIE_MOVIES")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id", nullable = false, unique = true)
    private Long movieId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "poster_image_url")
    private String posterImageUrl;

    @Column(name = "genre")
    private String genre;

    @Column(name = "duration")
    private Integer duration;
    
    @Column(name = "rating_age")
    private String ratingAge;

}
