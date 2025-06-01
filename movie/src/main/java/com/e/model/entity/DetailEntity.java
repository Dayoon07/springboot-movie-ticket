package com.e.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MOVIE_MOVIE_DETAILS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailEntity {
	
	@Id
	@Column(name = "movie_id", nullable = false, unique = true)
    private Long movieId;

    @OneToOne
    @MapsId
    @JoinColumn(name = "movie_id", nullable = false, foreignKey = @ForeignKey(name = "fk_details_movie"))
    private MovieEntity movie;

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
    
}
