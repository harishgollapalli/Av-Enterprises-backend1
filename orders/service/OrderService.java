package com.aventerprises.backend.orders.service;

import com.aventerprises.backend.orders.dto.*;
import com.aventerprises.backend.orders.entity.*;

import java.util.List;

public interface OrderService {
    Booking createBooking(Booking booking);
    OrderResponse createOrder(OrderRequest request);
    List<Booking> getBookingHistory(Long userId);
    List<Order> getOrdersByBooking(Long bookingId);
    CancellationRequest requestCancellation(Long bookingId, String reason);
    List<CancellationRequest> getCancellationsByBooking(Long bookingId);
}
