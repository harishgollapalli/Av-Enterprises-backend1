package com.aventerprises.backend.orders.service.impl;

import com.aventerprises.backend.orders.entity.Booking;
import com.aventerprises.backend.orders.entity.CancellationRequest;
import com.aventerprises.backend.orders.repository.BookingRepository;
import com.aventerprises.backend.orders.repository.CancellationRequestRepository;
import com.aventerprises.backend.orders.service.CancellationRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CancellationRequestServiceImpl implements CancellationRequestService {

    private final CancellationRequestRepository cancellationRequestRepository;
    private final BookingRepository bookingRepository;

    @Override
    public CancellationRequest createCancellationRequest(Long bookingId, String reason) {
        // Fetch booking to get userId
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        CancellationRequest request = CancellationRequest.builder()
                .bookingId(bookingId)
                .userId(booking.getUserId()) // ✅ Set userId from booking
                .reason(reason)
                .status(CancellationRequest.Status.PENDING)
                .requestDate(LocalDateTime.now())
                .build();

        return cancellationRequestRepository.save(request);
    }

    @Override
    public List<CancellationRequest> getRequestsByBooking(Long bookingId) {
        return cancellationRequestRepository.findByBookingId(bookingId);
    }

    @Override
    public List<CancellationRequest> getRequestsByUser(Long userId) {
        return cancellationRequestRepository.findByUserId(userId); // ✅ Safe now
    }
}
