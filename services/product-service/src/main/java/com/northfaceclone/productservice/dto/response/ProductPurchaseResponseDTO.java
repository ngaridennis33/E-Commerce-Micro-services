package com.northfaceclone.productservice.dto.response;

import java.math.BigDecimal;

public record ProductPurchaseResponseDTO(

        Long productId,
        String name,
        String description,
        BigDecimal price,
        double quantity
) {
}
