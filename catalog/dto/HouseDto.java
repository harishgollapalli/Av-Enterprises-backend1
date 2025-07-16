// HouseDto.java
package com.aventerprises.backend.catalog.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HouseDto {
    private Long id;
    private String ownerName;
    private String description;
    private String location;
    private Double rent;
    private int bedrooms;
    private String rules;
    private String idProof;
    private boolean available;
}