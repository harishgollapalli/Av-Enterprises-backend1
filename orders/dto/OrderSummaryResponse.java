package com.aventerprises.backend.orders.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor
public class OrderSummaryResponse {
    private Long orderId;
    private Long bookingId;
    private Double totalAmount;
    private String orderStatus;
    private LocalDateTime orderDate;
}
