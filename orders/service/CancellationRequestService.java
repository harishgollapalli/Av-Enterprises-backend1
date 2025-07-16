package com.aventerprises.backend.orders.service;

import com.aventerprises.backend.orders.entity.CancellationRequest;

import java.util.List;

public interface CancellationRequestService {
    CancellationRequest createCancellationRequest(Long bookingId, String reason);
    List<CancellationRequest> getRequestsByBooking(Long bookingId);
    List<CancellationRequest> getRequestsByUser(Long userId);
}
