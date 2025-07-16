package com.aventerprises.backend.catalog.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "commercials")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Commercial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String businessName;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String idProof;

    @Column(nullable = false)
    private String amenities;

    @Column(nullable = false)
    private boolean available = true;
}
