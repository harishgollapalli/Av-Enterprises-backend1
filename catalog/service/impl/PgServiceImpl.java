package com.aventerprises.backend.catalog.service.impl;

import com.aventerprises.backend.catalog.dto.PgDto;
import com.aventerprises.backend.catalog.entity.Pg;
import com.aventerprises.backend.catalog.repository.PgRepository;
import com.aventerprises.backend.catalog.service.PgService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PgServiceImpl implements PgService {

    private final PgRepository pgRepository;

    @Override
    public PgDto create(PgDto dto) {
        Pg pg = Pg.builder()
                .businessName(dto.getBusinessName())
                .description(dto.getDescription())
                .location(dto.getLocation())
                .price(dto.getPrice())
                .images(dto.getImages())
                .idProof(dto.getIdProof())
                .build();
        Pg saved = pgRepository.save(pg);
        dto.setId(saved.getId());
        return dto;
    }

    @Override
    public List<PgDto> getAll() {
        return pgRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public PgDto getById(Long id) {
        return pgRepository.findById(id)
                .map(this::toDto)
                .orElse(null);
    }

    private PgDto toDto(Pg pg) {
        return PgDto.builder()
                .id(pg.getId())
                .businessName(pg.getBusinessName())
                .description(pg.getDescription())
                .location(pg.getLocation())
                .price(pg.getPrice())
                .images(pg.getImages())
                .idProof(pg.getIdProof())
                .build();
    }
}
