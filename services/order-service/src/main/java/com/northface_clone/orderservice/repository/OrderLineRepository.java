package com.northface_clone.orderservice.repository;

import com.northface_clone.orderservice.models.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
}
