package com.e.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
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
@Table(name = "MOVIE_SHOWTIMES")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowtimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "showtime_id", nullable = false, unique = true)
	private Long showtimeId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name =  "movie_id", nullable = false, 
		foreignKey = @ForeignKey(name = "fk_showtime_movie")
	)
	private MovieEntity movieId;
	
	@ManyToOne
	@JoinColumn(name = "cinema_id", nullable = false, 
		foreignKey = @ForeignKey(name = "fk_showtime_cinema")
	)
	private CinemaEntity cinemaId;
	
	@Column(name = "show_date", nullable = false)
    private LocalDate showDate;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    @Column(name = "available_seats")
    private Integer availableSeats;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "status")
    private String status;

}
