package com.aventerprises.backend.orders.controller;

import com.aventerprises.backend.orders.dto.PaymentDTO;
import com.aventerprises.backend.orders.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<PaymentDTO> makePayment(@RequestBody PaymentDTO dto) {
        return ResponseEntity.ok(paymentService.processPayment(dto));
    }

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<PaymentDTO>> getPaymentsByOrder(@PathVariable Long orderId) {
        return ResponseEntity.ok(paymentService.getPaymentsByOrderId(orderId));
    }
}
