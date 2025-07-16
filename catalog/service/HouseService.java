// HouseService.java
package com.aventerprises.backend.catalog.service;

import com.aventerprises.backend.catalog.dto.HouseDto;

import java.util.List;

public interface HouseService {
    HouseDto create(HouseDto dto, String email);
    List<HouseDto> getAll();
    HouseDto getById(Long id);
    HouseDto update(Long id, HouseDto dto, String email);
    void delete(Long id, String email);
}