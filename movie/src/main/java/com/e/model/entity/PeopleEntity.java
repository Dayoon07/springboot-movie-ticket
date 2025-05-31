package com.e.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "MOVIE_PEOPLE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PeopleEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "person_id", nullable = false, unique = true)
	private Long personId;
	
	@Column(name = "name", nullable = false)
    private String name;
	
	@Column(name = "birth")
    private LocalDateTime birth;
	
	@Column(name = "nationality")
    private String nationality;
	
	@Column(name = "profile_image_url")
    private String profileImageUrl;
	
	@Lob
	@Column(name = "bio")
    private String bio;

}
