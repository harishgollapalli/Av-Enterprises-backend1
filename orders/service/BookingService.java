package com.aventerprises.backend.orders.service;

import com.aventerprises.backend.orders.dto.*;

import java.util.List;

public interface BookingService {
    BookingResponse createBooking(BookingRequest request);
    List<BookingHistoryResponse> getBookingHistory(Long userId);
    String requestCancellation(CancellationRequestDTO dto);
}
