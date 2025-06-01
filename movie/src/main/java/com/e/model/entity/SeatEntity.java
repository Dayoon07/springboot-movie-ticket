package com.e.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "MOVIE_SEATS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeatEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private Long seatId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theater_id", nullable = false, unique = true, foreignKey = @ForeignKey(name = "fk_seat_theater"))
    private TheaterEntity theaterId;

    @Column(name = "row_name", nullable = false, unique = true)
    private String rowName;

    @Column(name = "seat_number", nullable = false, unique = true)
    private Integer seatNumber;

    @Column(name = "seat_type")
    private String seatType;

    @Column(name = "status")
    private String status;
    
}
