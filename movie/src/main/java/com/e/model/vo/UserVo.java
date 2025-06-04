package com.e.model.vo;

import java.time.LocalDateTime;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserVo {
    private Long userId;
    private String phone;
    private String name;
    private String email;
    private String password;
    private LocalDateTime createAt;
}