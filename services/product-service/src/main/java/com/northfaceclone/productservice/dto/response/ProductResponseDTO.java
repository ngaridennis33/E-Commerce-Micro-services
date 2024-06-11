package com.northfaceclone.productservice.dto.response;

import java.math.BigDecimal;

public record ProductResponseDTO(

        Long id,
        String name,
        String description,
        double availableQuantity,
        BigDecimal price,
        Long categoryId,
        String categoryName,
        String categoryDescription
) {
}
