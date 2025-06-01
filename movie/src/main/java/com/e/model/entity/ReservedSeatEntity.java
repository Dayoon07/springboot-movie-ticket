package com.e.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MOVIE_RESERVED_SEATS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservedSeatEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reserved_seat_id", nullable = false, unique = true)
    private Long reservedSeatId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "reservation_id", nullable = false, foreignKey = @ForeignKey(name = "fk_reserved_reservation"))
    private ReservationEntity reservationId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "seat_id", nullable = false, foreignKey = @ForeignKey(name = "fk_reserved_seat"))
    private SeatEntity seatId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "showtime_id", nullable = false, foreignKey = @ForeignKey(name = "fk_reserved_showtime"))
    private ShowtimeEntity showtimeId;
    
}
