package com.aventerprises.backend.core.repository;

import com.aventerprises.backend.core.entity.Role;
import com.aventerprises.backend.core.entity.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleType name);
}
