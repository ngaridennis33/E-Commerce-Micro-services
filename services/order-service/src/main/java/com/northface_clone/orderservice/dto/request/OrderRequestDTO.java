package com.northface_clone.orderservice.dto.request;

import com.northface_clone.orderservice.models.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequestDTO(
        Long id,
        String reference,

        @Positive(message = "Order amount should be positive")
        BigDecimal amount,

        @NotNull(message = "Customer should be present")
        @NotEmpty(message = "Customer should be present")
        @NotBlank(message = "Customer should be present")
        Long customerId,

        @NotNull(message = "Payment method should be specified")
        PaymentMethod paymentMethod,

        @NotEmpty(message = "You should at least purchase one product")
        List<PurchaseRequestDTO> products

) {
}
