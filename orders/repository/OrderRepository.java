// OrderRepository.java
package com.aventerprises.backend.orders.repository;

import com.aventerprises.backend.orders.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByBookingId(Long bookingId);
}