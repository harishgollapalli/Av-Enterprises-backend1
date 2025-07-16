package com.aventerprises.backend.catalog.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "pgs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pg {

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
    private double price;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> images;

    @Column(nullable = false)
    private String idProof;
}
