package com.northface_clone.paymentservice.repository;

import com.northface_clone.paymentservice.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
