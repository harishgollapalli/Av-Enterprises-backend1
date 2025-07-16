package com.aventerprises.backend.catalog.controller;

import com.aventerprises.backend.catalog.dto.CommercialDto;
import com.aventerprises.backend.catalog.service.CommercialService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/commercials")
@RequiredArgsConstructor
public class CommercialController {

    private final CommercialService service;

    @PreAuthorize("hasAnyRole('USER', 'OWNER', 'ADMIN')")
    @PostMapping
    public CommercialDto create(@RequestBody CommercialDto dto) {
        return service.create(dto);
    }

    @PreAuthorize("hasAnyRole('USER', 'OWNER', 'ADMIN')")
    @GetMapping
    public List<CommercialDto> getAll() {
        return service.getAll();
    }

    @PreAuthorize("hasAnyRole('USER', 'OWNER', 'ADMIN')")
    @GetMapping("/{id}")
    public CommercialDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @PreAuthorize("hasAnyRole('OWNER', 'ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
