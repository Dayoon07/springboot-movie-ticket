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
@Table(name = "MOVIE_THEATERS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheaterEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "theater_id", nullable = false, unique = true)
	private Long theaterId;
	
	@Column(name = "theater_name", nullable = false)
    private String theaterName;
	
	@Column(name = "total_seats", nullable = false)
    private Integer totalSeats;
	
	@Column(name = "theater_type")
    private String theaterType;
	
}
