package com.northfaceclone.productservice.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequestDTO(

        Long id,

        @NotNull(message = "Product name is required!")
        String name,

        @NotNull(message = "Product Description is required!")
        String description,

        @NotNull(message = "Product Quantity is required!")
        @Positive(message = "Quantity MUST be a Positive number")
        double availableQuantity,

        @NotNull(message = "Product Price is required!")
        @Positive(message = "Price should be positive")
        BigDecimal price,

        @NotNull(message = "Product category is required!")
        Long categoryId
) {
}
