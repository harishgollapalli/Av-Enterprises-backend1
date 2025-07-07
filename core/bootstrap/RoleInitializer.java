package com.aventerprises.backend.core.bootstrap;

import com.aventerprises.backend.core.entity.Role;
import com.aventerprises.backend.core.entity.RoleType;
import com.aventerprises.backend.core.repository.RoleRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleInitializer {

    private final RoleRepository roleRepository;

    @PostConstruct
    public void initRoles() {
        for (RoleType roleType : RoleType.values()) {
            roleRepository.findByName(roleType)
                    .orElseGet(() -> roleRepository.save(new Role(null, roleType)));
        }
    }
}
