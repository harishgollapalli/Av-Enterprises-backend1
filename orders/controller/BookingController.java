package com.aventerprises.backend.orders.controller;

import com.aventerprises.backend.orders.dto.*;
import com.aventerprises.backend.orders.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public ResponseEntity<BookingResponse> create(@RequestBody BookingRequest req) {
        return ResponseEntity.ok(bookingService.createBooking(req));
    }

    @GetMapping("/history/{userId}")
    public ResponseEntity<List<BookingHistoryResponse>> history(@PathVariable Long userId) {
        return ResponseEntity.ok(bookingService.getBookingHistory(userId));
    }

    @PostMapping("/cancel")
    public ResponseEntity<String> cancel(@RequestBody CancellationRequestDTO dto) {
        return ResponseEntity.ok(bookingService.requestCancellation(dto));
    }
}
