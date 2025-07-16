package com.aventerprises.backend.catalog.service;

import com.aventerprises.backend.catalog.dto.CommercialDto;
import java.util.List;

public interface CommercialService {
    CommercialDto create(CommercialDto dto);
    List<CommercialDto> getAll();
    CommercialDto getById(Long id);
    void delete(Long id);
}
