package com.aventerprises.backend.orders.repository;

import com.aventerprises.backend.orders.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUserId(Long userId);
    List<Booking> findByUserIdOrderByCheckInDateDesc(Long userId); // ✅ Added
}
