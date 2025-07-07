package com.aventerprises.backend.core.service;

import com.aventerprises.backend.core.dto.UserDTO;
import com.aventerprises.backend.core.entity.User;

public interface UserService {
    void registerUser(UserDTO userDTO);

    User findByEmail(String email); // ✅ Add this
}
