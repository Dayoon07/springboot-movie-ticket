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
	@Column(name = "cast_id", nullable = false, unique = true)
	private Long castId;

	@ManyToOne
	@JoinColumn(name = "movie_id", nullable = false, foreignKey = @ForeignKey(name = "fk_cast_movie"))
	private MovieEntity movieId;

	@ManyToOne
	@JoinColumn(name = "person_id", nullable = false, foreignKey = @ForeignKey(name = "fk_cast_person"))
	private PeopleEntity personId;

	@Column(name = "role")
	private String role;
	
}
