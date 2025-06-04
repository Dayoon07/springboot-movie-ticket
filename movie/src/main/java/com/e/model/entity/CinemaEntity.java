package com.e.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MOVIE_CINEMAS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CinemaEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cinema_id", nullable = false, unique = true)
	private Long cinemaId;
	
	@Column(name = "cinema_name", nullable = false)
	private String cinemaName;
	
	@Column(name = "total_seats", nullable = false)
	private Long totalSeats;
	
	@Column(name = "cinema_type")
	private String cinemaType;
	
	@Lob
	@Column(name = "seat_layout")
	private String seatLayout;

}
