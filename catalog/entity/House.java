package com.aventerprises.backend.catalog.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "houses")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class House {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String ownerName;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private Double rent;

    @Column(nullable = false)
    private int bedrooms;

    @Column(nullable = false)
    private String rules;

    @Column(nullable = false)
    private String idProof;

    @Column(nullable = false)
    private String pincode;

    @Column(nullable = false)
    private boolean available = true;
}
