package com.aventerprises.backend.catalog.repository;

import com.aventerprises.backend.catalog.entity.Commercial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommercialRepository extends JpaRepository<Commercial, Long> {
}
