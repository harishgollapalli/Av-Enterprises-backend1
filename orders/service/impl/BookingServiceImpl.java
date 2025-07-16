package com.aventerprises.backend.orders.service.impl;

import com.aventerprises.backend.orders.dto.*;
import com.aventerprises.backend.orders.entity.Booking;
import com.aventerprises.backend.orders.repository.BookingRepository;
import com.aventerprises.backend.orders.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Override
    public BookingResponse createBooking(BookingRequest request) {
        Booking b = Booking.builder()
            .userId(request.getUserId())
            .propertyId(request.getPropertyId())
            .propertyType(request.getPropertyType())
            .checkInDate(request.getCheckInDate())
            .checkOutDate(request.getCheckOutDate())
            .amount(request.getAmount())
            .status("PENDING")
            .build();
        Booking saved = bookingRepository.save(b);
        return new BookingResponse(saved.getId(), saved.getUserId(), saved.getPropertyId(),
            saved.getPropertyType(), saved.getCheckInDate(), saved.getCheckOutDate(),
            saved.getAmount(), saved.getStatus());
    }

    @Override
    public List<BookingHistoryResponse> getBookingHistory(Long userId) {
        return bookingRepository.findByUserIdOrderByCheckInDateDesc(userId).stream()
            .map(b -> new BookingHistoryResponse(b.getId(), b.getPropertyId(), b.getPropertyType(),
                b.getCheckInDate(), b.getCheckOutDate(), b.getAmount(), b.getStatus()))
            .collect(Collectors.toList());
    }

    @Override
    public String requestCancellation(CancellationRequestDTO dto) {
        Booking b = bookingRepository.findById(dto.getBookingId())
            .orElseThrow(() -> new RuntimeException("Booking not found"));
        if (!"PENDING".equalsIgnoreCase(b.getStatus())) {
            return "Only pending bookings can be cancelled";
        }
        b.setStatus("CANCEL_REQUESTED");
        bookingRepository.save(b);
        return "Cancellation requested successfully";
    }
}
