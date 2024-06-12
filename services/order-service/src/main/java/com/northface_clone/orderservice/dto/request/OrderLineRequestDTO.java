package com.northface_clone.orderservice.dto.request;

public record OrderLineRequestDTO(
        Long id,
        Long orderId,
        Long productId,
        double quantity

) {
}
