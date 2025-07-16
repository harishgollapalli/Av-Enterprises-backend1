package com.aventerprises.backend.catalog.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PgDto {
    private Long id;
    private String businessName;
    private String description;
    private String location;
    private double price;
    private List<String> images;
    private String idProof;
}
