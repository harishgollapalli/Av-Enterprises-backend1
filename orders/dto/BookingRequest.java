package com.aventerprises.backend.orders.dto;

import lombok.*;
import java.time.LocalDate;

@Data @NoArgsConstructor @AllArgsConstructor
public class BookingRequest {
    private Long userId;
    private Long propertyId;
    private String propertyType;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Double amount;
}
