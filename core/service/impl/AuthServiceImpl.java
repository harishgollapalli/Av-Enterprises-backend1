package com.aventerprises.backend.core.service.impl;

import com.aventerprises.backend.core.dto.AuthenticationRequest;
import com.aventerprises.backend.core.dto.AuthenticationResponse;
import com.aventerprises.backend.core.dto.RegisterRequest;
import com.aventerprises.backend.core.entity.Role;
import com.aventerprises.backend.core.entity.RoleType;
import com.aventerprises.backend.core.entity.User;
import com.aventerprises.backend.core.jwt.JwtService;
import com.aventerprises.backend.core.repository.UserRepository;
import com.aventerprises.backend.core.service.AuthService;
import com.aventerprises.backend.core.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final RoleService roleService;
    private final JwtService jwtService;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            return AuthenticationResponse.builder()
                    .message("Email already exists")
                    .build();
        }

        Role defaultRole = roleService.getRoleByName(RoleType.ROLE_USER);

        User user = User.builder()
                .email(request.getEmail())
                .fullName(request.getFullName())
                .phone(request.getPhone())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(Collections.singleton(defaultRole))
                .build();

        userRepository.save(user);

        String token = jwtService.generateToken(
                user.getEmail(),
                user.getRoles().stream()
                        .map(role -> role.getName().name())
                        .collect(Collectors.toList())
        );

        return AuthenticationResponse.builder()
                .token(token)
                .message("User registered successfully")
                .build();
    }

    @Override
    public AuthenticationResponse login(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Invalid email or password"));

        String token = jwtService.generateToken(
                user.getEmail(),
                user.getRoles().stream()
                        .map(role -> role.getName().name())
                        .collect(Collectors.toList())
        );

        return AuthenticationResponse.builder()
                .token(token)
                .message("Login successful - Role: " + user.getRoles().stream().findFirst().get().getName())
                .build();
    }
}
