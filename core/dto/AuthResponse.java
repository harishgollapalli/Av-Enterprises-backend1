package com.aventerprises.backend.core.dto;

import com.aventerprises.backend.core.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private String email;
    private String fullName;
    private Set<Role> roles;
}
