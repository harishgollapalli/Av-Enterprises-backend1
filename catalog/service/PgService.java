package com.aventerprises.backend.catalog.service;

import com.aventerprises.backend.catalog.dto.PgDto;

import java.util.List;

public interface PgService {
    PgDto create(PgDto dto);
    List<PgDto> getAll();
    PgDto getById(Long id);
}
