package com.aventerprises.backend.core.service;

import com.aventerprises.backend.core.dto.AuthenticationRequest;
import com.aventerprises.backend.core.dto.AuthenticationResponse;
import com.aventerprises.backend.core.dto.RegisterRequest;

public interface AuthService {
    AuthenticationResponse register(RegisterRequest request);
    AuthenticationResponse login(AuthenticationRequest request);
}
