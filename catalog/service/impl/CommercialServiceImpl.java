package com.aventerprises.backend.catalog.service.impl;

import com.aventerprises.backend.catalog.dto.CommercialDto;
import com.aventerprises.backend.catalog.entity.Commercial;
import com.aventerprises.backend.catalog.repository.CommercialRepository;
import com.aventerprises.backend.catalog.service.CommercialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommercialServiceImpl implements CommercialService {

    private final CommercialRepository repo;

    @Override
    public CommercialDto create(CommercialDto dto) {
        Commercial commercial = Commercial.builder()
                .businessName(dto.getBusinessName())
                .description(dto.getDescription())
                .location(dto.getLocation())
                .price(dto.getPrice())
                .available(dto.isAvailable())
                .build();
        return toDto(repo.save(commercial));
    }

    @Override
    public List<CommercialDto> getAll() {
        return repo.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CommercialDto getById(Long id) {
        return repo.findById(id)
                .map(this::toDto)
                .orElse(null);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

    private CommercialDto toDto(Commercial c) {
        return CommercialDto.builder()
                .id(c.getId())
                .businessName(c.getBusinessName())
                .description(c.getDescription())
                .location(c.getLocation())
                .price(c.getPrice())
                .available(c.isAvailable())
                .build();
    }
}
