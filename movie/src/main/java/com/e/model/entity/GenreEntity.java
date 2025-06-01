package com.e.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MOVIE_GENRES")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenreEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "genre_id", nullable = false, unique = true)
    private Long genreId;

    @Column(name = "genre_name", nullable = false, length = 50)
    private String genreName;
    
}