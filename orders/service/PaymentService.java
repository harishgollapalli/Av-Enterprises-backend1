package com.aventerprises.backend.orders.service;

import com.aventerprises.backend.orders.dto.PaymentDTO;

import java.util.List;

public interface PaymentService {
    PaymentDTO processPayment(PaymentDTO dto);
    List<PaymentDTO> getPaymentsByOrderId(Long orderId);
}
