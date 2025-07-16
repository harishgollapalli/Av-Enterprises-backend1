package com.aventerprises.backend.orders.repository;

import com.aventerprises.backend.orders.entity.CancellationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CancellationRequestRepository extends JpaRepository<CancellationRequest, Long> {
    List<CancellationRequest> findByBookingId(Long bookingId);
    List<CancellationRequest> findByUserId(Long userId); // ✅ Now valid
}
