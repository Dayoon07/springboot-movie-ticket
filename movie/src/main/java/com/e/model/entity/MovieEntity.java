package com.e.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

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

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Column(name = "poster_image_url")
    private String posterImageUrl;

    @Column(name = "genre")
    private String genre;

    @Column(name = "rating")
    private String rating;

    @Column(name = "age_rating")
    private String ageRating;

    @Lob
    @Column(name = "synopsis")
    private String synopsis;

    @Column(name = "duration")
    private Integer duration;

    @Column(name = "language")
    private String language;

    @Column(name = "country")
    private String country;

    @Column(name = "release_type")
    private String releaseType;

    @CreationTimestamp
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    @CreationTimestamp
    @Column(name = "updated_date", updatable = false)
    private LocalDateTime updatedDate;

}
