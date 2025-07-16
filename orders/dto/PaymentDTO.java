package com.aventerprises.backend.orders.dto;

import com.aventerprises.backend.core.enums.PaymentMode;
import com.aventerprises.backend.core.enums.PaymentStatus;
import lombok.*;

import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class PaymentDTO {
    private Long paymentId;
    private Long orderId;
    private Double amountPaid;
    private PaymentMode paymentMode;
    private PaymentStatus paymentStatus;
    private LocalDateTime paymentDate;
}
