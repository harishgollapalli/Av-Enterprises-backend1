// AuthenticationResponse.java
package com.aventerprises.backend.core.dto;

import lombok.*;
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class AuthenticationResponse {
    private String token;
    private String email;
    private String fullName;
    private String role;
    private String message;
}
