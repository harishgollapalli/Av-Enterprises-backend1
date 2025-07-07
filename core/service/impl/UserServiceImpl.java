package com.aventerprises.backend.core.service.impl;

import com.aventerprises.backend.core.dto.UserDTO;
import com.aventerprises.backend.core.entity.Role;
import com.aventerprises.backend.core.entity.RoleType;
import com.aventerprises.backend.core.entity.User;
import com.aventerprises.backend.core.repository.UserRepository;
import com.aventerprises.backend.core.service.RoleService;
import com.aventerprises.backend.core.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void registerUser(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        Role defaultRole = roleService.getRoleByName(RoleType.ROLE_USER);

        User user = User.builder()
                .email(userDTO.getEmail())
                .fullName(userDTO.getFullName())
                .phone(userDTO.getPhone())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .roles(Collections.singleton(defaultRole))
                .build();

        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() ->
                new RuntimeException("User not found with email: " + email));
    }
}
