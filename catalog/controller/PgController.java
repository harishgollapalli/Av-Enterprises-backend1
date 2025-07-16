package com.aventerprises.backend.catalog.controller;

import com.aventerprises.backend.catalog.dto.PgDto;
import com.aventerprises.backend.catalog.service.PgService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pgs")
@RequiredArgsConstructor
public class PgController {

    private final PgService pgService;

    @PostMapping
    public ResponseEntity<PgDto> create(@RequestBody PgDto dto) {
        return ResponseEntity.ok(pgService.create(dto));
    }

    @GetMapping
    public ResponseEntity<List<PgDto>> getAll() {
        return ResponseEntity.ok(pgService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PgDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(pgService.getById(id));
    }
}
