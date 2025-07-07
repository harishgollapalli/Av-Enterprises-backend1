package com.aventerprises.backend.core.service;

import com.aventerprises.backend.core.entity.Role;
import com.aventerprises.backend.core.entity.RoleType;

import java.util.List;

public interface RoleService {
    Role getRoleByName(RoleType roleType);
    List<Role> getAllRoles();  // 👈 add this
}
