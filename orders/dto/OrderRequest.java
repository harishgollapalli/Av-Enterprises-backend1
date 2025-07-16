package com.aventerprises.backend.orders.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private Long bookingId;
    private Double totalAmount;
    private String orderStatus; // ✅ Add this field to accept enum as string
}
