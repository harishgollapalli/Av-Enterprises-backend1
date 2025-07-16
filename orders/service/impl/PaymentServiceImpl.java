package com.aventerprises.backend.orders.service.impl;

import com.aventerprises.backend.orders.dto.PaymentDTO;
import com.aventerprises.backend.orders.entity.Payment;
import com.aventerprises.backend.orders.repository.PaymentRepository;
import com.aventerprises.backend.orders.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepo;

    @Override
    public PaymentDTO processPayment(PaymentDTO dto) {
        Payment payment = Payment.builder()
                .orderId(dto.getOrderId())
                .amountPaid(dto.getAmountPaid())
                .paymentMode(dto.getPaymentMode())
                .paymentStatus(dto.getPaymentStatus())
                .paymentDate(LocalDateTime.now())
                .build();

        Payment saved = paymentRepo.save(payment);

        return PaymentDTO.builder()
                .paymentId(saved.getId())
                .orderId(saved.getOrderId())
                .amountPaid(saved.getAmountPaid())
                .paymentMode(saved.getPaymentMode())
                .paymentStatus(saved.getPaymentStatus())
                .paymentDate(saved.getPaymentDate())
                .build();
    }

    @Override
    public List<PaymentDTO> getPaymentsByOrderId(Long orderId) {
        return paymentRepo.findByOrderId(orderId).stream()
                .map(p -> PaymentDTO.builder()
                        .paymentId(p.getId())
                        .orderId(p.getOrderId())
                        .amountPaid(p.getAmountPaid())
                        .paymentMode(p.getPaymentMode())
                        .paymentStatus(p.getPaymentStatus())
                        .paymentDate(p.getPaymentDate())
                        .build())
                .collect(Collectors.toList());
    }
}
