package com.aventerprises.backend.orders.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CancellationRequestDTO {
    private Long bookingId;
    private String reason;
    private Long userId; // ✅ Optional for response display (not needed in request)
}
