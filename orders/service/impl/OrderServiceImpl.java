package com.aventerprises.backend.orders.service.impl;

import com.aventerprises.backend.core.enums.OrderStatus;
import com.aventerprises.backend.orders.dto.OrderRequest;
import com.aventerprises.backend.orders.dto.OrderResponse;
import com.aventerprises.backend.orders.entity.*;
import com.aventerprises.backend.orders.repository.*;
import com.aventerprises.backend.orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final BookingRepository bookingRepo;
    private final OrderRepository orderRepo;
    private final CancellationRequestRepository cancelRepo;

    @Override
    public Booking createBooking(Booking booking) {
        booking.setStatus("PENDING");
        return bookingRepo.save(booking);
    }

    @Override
    public OrderResponse createOrder(OrderRequest request) {
        OrderStatus status;
        try {
            status = OrderStatus.valueOf(request.getOrderStatus().toUpperCase());
        } catch (IllegalArgumentException ex) {
            throw new RuntimeException("Invalid order status: " + request.getOrderStatus());
        }

        Order order = Order.builder()
                .bookingId(request.getBookingId())
                .totalAmount(request.getTotalAmount())
                .orderStatus(status)
                .orderDate(LocalDateTime.now())
                .build();

        Order saved = orderRepo.save(order);

        return new OrderResponse(
                saved.getId(),
                saved.getBookingId(),
                saved.getTotalAmount(),
                saved.getOrderStatus(),
                saved.getOrderDate()
        );
    }

    @Override
    public List<Booking> getBookingHistory(Long userId) {
        return bookingRepo.findByUserId(userId);
    }

    @Override
    public List<Order> getOrdersByBooking(Long bookingId) {
        return orderRepo.findByBookingId(bookingId);
    }

    @Override
    public CancellationRequest requestCancellation(Long bookingId, String reason) {
        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        CancellationRequest req = CancellationRequest.builder()
                .bookingId(bookingId)
                .userId(booking.getUserId())
                .reason(reason)
                .status(CancellationRequest.Status.PENDING)
                .requestDate(LocalDateTime.now())
                .build();

        return cancelRepo.save(req);
    }

    @Override
    public List<CancellationRequest> getCancellationsByBooking(Long bookingId) {
        return cancelRepo.findByBookingId(bookingId);
    }
}
