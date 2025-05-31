package com.e.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private LocalDateTime releaseDate;

    @Column(name = "poster_image_url")
    private String posterImageUrl;

    @ManyToOne
    @JoinColumn(name = "rating_id")
    private RatingEntity rating;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    private GenreEntity genre;

    @ManyToOne
    @JoinColumn(name = "age_rating_id")
    private AgeRatingEntity ageRating;

    @Column(name = "status")
    private String status;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
	
}