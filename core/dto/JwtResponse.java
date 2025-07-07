package com.aventerprises.backend.core.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {
    private String token;
    private String email;
    private String role;
}

