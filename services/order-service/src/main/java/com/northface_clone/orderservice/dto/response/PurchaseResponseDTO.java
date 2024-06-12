package com.northface_clone.orderservice.dto.response;

import java.math.BigDecimal;

public record PurchaseResponseDTO(
        Long productId,
        String name,
        String description,
        BigDecimal price,
        double quantity
) {
}
