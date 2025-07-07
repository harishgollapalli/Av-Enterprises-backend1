package com.aventerprises.backend.core.dto;

import com.aventerprises.backend.core.entity.RoleType;

import lombok.Data;
@Data
public class UserDTO {
    private String fullName;
    private String email;
    private String password;
    private String phone;
    private RoleType role; // ENUM
}
