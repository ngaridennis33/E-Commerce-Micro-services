package com.northface_clone.orderservice.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PurchaseRequestDTO(
        @NotNull(message = "Product is mandatory")
        Long productId,

        @Positive(message = "Quantity is mandatory")
        double quantity
) {
}
