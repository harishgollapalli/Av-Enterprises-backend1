package com.aventerprises.backend.core.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String fullName;
    private String email;
    private String password;
    private String phone;
    private String countryCode;
    private String country;
    private String state;
    private String pincode;
    private String address;
    private String gender;
    private String dob;
    private String occupation;
}
