package com.aventerprises.backend.catalog.controller;

import com.aventerprises.backend.catalog.dto.HouseDto;
import com.aventerprises.backend.catalog.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/houses")
@RequiredArgsConstructor
public class HouseController {

    private final HouseService service;

    @PostMapping
    public HouseDto create(@RequestBody HouseDto dto,
                           @RequestHeader("X-User-Email") String email) {
        return service.create(dto, email);
    }

    @PutMapping("/{id}")
    public HouseDto update(@PathVariable Long id,
                           @RequestBody HouseDto dto,
                           @RequestHeader("X-User-Email") String email) {
        return service.update(id, dto, email);
    }

    @GetMapping
    public List<HouseDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public HouseDto getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id,
                       @RequestHeader("X-User-Email") String email) {
        service.delete(id, email);
    }
}
