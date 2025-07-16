package com.aventerprises.backend.orders.dto;

import com.aventerprises.backend.core.enums.OrderStatus;
import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponse {
    private Long orderId;
    private Long bookingId;
    private Double totalAmount;
    private OrderStatus orderStatus;
    private LocalDateTime orderDate;
}
