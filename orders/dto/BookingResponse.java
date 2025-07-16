package com.aventerprises.backend.orders.dto;

import lombok.*;
import java.time.LocalDate;

@Data @NoArgsConstructor @AllArgsConstructor
public class BookingResponse {
    private Long bookingId;
    private Long userId;
    private Long propertyId;
    private String propertyType;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Double amount;
    private String status;
}
