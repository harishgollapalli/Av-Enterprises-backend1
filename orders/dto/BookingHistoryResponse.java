package com.aventerprises.backend.orders.dto;

import lombok.*;
import java.time.LocalDate;

@Data @NoArgsConstructor @AllArgsConstructor
public class BookingHistoryResponse {
    private Long bookingId;
    private Long propertyId;
    private String propertyType;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Double amount;
    private String status;
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}
}
