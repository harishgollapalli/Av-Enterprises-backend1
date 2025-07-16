package com.aventerprises.backend.orders.controller;

import com.aventerprises.backend.orders.dto.*;
import com.aventerprises.backend.orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    // Create a new order
    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest request) {
        OrderResponse response = orderService.createOrder(request);
        return ResponseEntity.ok(response);
    }

    // Get all orders linked to a specific booking
    @GetMapping("/booking/{bookingId}")
    public ResponseEntity<List<OrderResponse>> getOrdersByBooking(@PathVariable Long bookingId) {
        List<OrderResponse> orders = orderService.getOrdersByBooking(bookingId).stream().map(order ->
            new OrderResponse(
                order.getId(),
                order.getBookingId(),
                order.getTotalAmount(),
                order.getOrderStatus(),
                order.getOrderDate()
            )
        ).toList();
        return ResponseEntity.ok(orders);
    }
}
