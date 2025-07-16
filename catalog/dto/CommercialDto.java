package com.aventerprises.backend.catalog.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommercialDto {
    private Long id;
    private String businessName;
    private String description;
    private String location;
    private Double price;
    private boolean available;
}
