package com.e.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MOVIE_RATINGS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RatingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rating_id", nullable = false, unique = true)
	private Long ratingId;
	
	@Column(name = "rating_name", unique = true)
    private String ratingName;
	
	@Column(name = "description")
    private String description;
	
}
