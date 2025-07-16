// HouseServiceImpl.java
package com.aventerprises.backend.catalog.service.impl;

import com.aventerprises.backend.catalog.dto.HouseDto;
import com.aventerprises.backend.catalog.entity.House;
import com.aventerprises.backend.catalog.repository.HouseRepository;
import com.aventerprises.backend.catalog.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {

    private final HouseRepository repo;

    @Override
    public HouseDto create(HouseDto dto, String email) {
        House house = House.builder()
                .ownerName(dto.getOwnerName())
                .description(dto.getDescription())
                .location(dto.getLocation())
                .rent(dto.getRent())
                .bedrooms(dto.getBedrooms())
                .rules(dto.getRules())
                .idProof(dto.getIdProof())
                .available(dto.isAvailable())
                .build();
        return toDto(repo.save(house));
    }

    @Override
    public List<HouseDto> getAll() {
        return repo.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public HouseDto getById(Long id) {
        return repo.findById(id).map(this::toDto).orElse(null);
    }

    @Override
    public HouseDto update(Long id, HouseDto dto, String email) {
        House house = repo.findById(id).orElseThrow(() -> new RuntimeException("House not found"));
        house.setOwnerName(dto.getOwnerName());
        house.setDescription(dto.getDescription());
        house.setLocation(dto.getLocation());
        house.setRent(dto.getRent());
        house.setBedrooms(dto.getBedrooms());
        house.setRules(dto.getRules());
        house.setIdProof(dto.getIdProof());
        house.setAvailable(dto.isAvailable());
        return toDto(repo.save(house));
    }

    @Override
    public void delete(Long id, String email) {
        repo.deleteById(id);
    }

    private HouseDto toDto(House h) {
        return HouseDto.builder()
                .id(h.getId())
                .ownerName(h.getOwnerName())
                .description(h.getDescription())
                .location(h.getLocation())
                .rent(h.getRent())
                .bedrooms(h.getBedrooms())
                .rules(h.getRules())
                .idProof(h.getIdProof())
                .available(h.isAvailable())
                .build();
    }
}

