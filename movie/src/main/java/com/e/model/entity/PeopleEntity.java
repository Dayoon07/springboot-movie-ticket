package com.e.model.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PeopleEntity {
	private Long personId;
    private String name;
    private LocalDateTime birth;
    private String nationality;
    private String profileImageUrl;
    private String bio;
}
