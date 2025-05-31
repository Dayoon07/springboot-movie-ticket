package com.e.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MOVIE_CAST")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CastEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long castId;

	@ManyToOne
	@JoinColumn(name = "movie_id")
	private MovieEntity movie;

	@ManyToOne
	@JoinColumn(name = "person_id")
	private PeopleEntity person;

	private String role;
	
}
