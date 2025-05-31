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
@Table(name = "MOVIE_AGE_RATINGS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AgeRatingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "age_rating_id", nullable = false, unique = true)
	private Long ageRatingId;
	
	@Column(name = "age_rating_name", nullable = false)
    private String ageRatingName;
	
	@Column(name = "description")
    private String description;
	
}
