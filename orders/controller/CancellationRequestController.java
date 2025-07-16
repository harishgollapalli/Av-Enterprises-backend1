package com.aventerprises.backend.orders.controller;

import com.aventerprises.backend.orders.dto.CancellationRequestDTO;
import com.aventerprises.backend.orders.entity.CancellationRequest;
import com.aventerprises.backend.orders.service.CancellationRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cancellations")
@RequiredArgsConstructor
public class CancellationRequestController {

    private final CancellationRequestService cancellationRequestService;

    // ✅ Create cancellation request with @RequestBody
    @PostMapping("/request")
    public ResponseEntity<CancellationRequestDTO> requestCancellation(
            @RequestBody CancellationRequestDTO request
    ) {
        CancellationRequest created = cancellationRequestService.createCancellationRequest(
                request.getBookingId(),
                request.getReason()
        );

        // Convert to DTO with userId included
        CancellationRequestDTO response = CancellationRequestDTO.builder()
                .bookingId(created.getBookingId())
                .reason(created.getReason())
                .userId(created.getUserId())
                .build();

        return ResponseEntity.ok(response);
    }

    // ✅ Get cancellations by booking ID
    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<List<CancellationRequestDTO>> getByBookingId(@PathVariable Long bookingId) {
        List<CancellationRequestDTO> responses = cancellationRequestService
                .getRequestsByBooking(bookingId)
                .stream()
                .map(req -> CancellationRequestDTO.builder()
                        .bookingId(req.getBookingId())
                        .reason(req.getReason())
                        .userId(req.getUserId())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(responses);
    }

    // ✅ Get cancellations by user ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<CancellationRequestDTO>> getByUserId(@PathVariable Long userId) {
        List<CancellationRequestDTO> responses = cancellationRequestService
                .getRequestsByUser(userId)
                .stream()
                .map(req -> CancellationRequestDTO.builder()
                        .bookingId(req.getBookingId())
                        .reason(req.getReason())
                        .userId(req.getUserId())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.ok(responses);
    }
}
