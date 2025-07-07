package com.aventerprises.backend.core.service.impl;

import com.aventerprises.backend.core.entity.Role;
import com.aventerprises.backend.core.entity.RoleType;
import com.aventerprises.backend.core.repository.RoleRepository;
import com.aventerprises.backend.core.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Role getRoleByName(RoleType roleType) {
        return roleRepository.findByName(roleType)
                .orElseThrow(() -> new RuntimeException("Role not found: " + roleType));
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();  // ✅ get all roles from DB
    }
}
