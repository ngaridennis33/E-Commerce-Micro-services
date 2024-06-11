package com.northfaceclone.productservice.dto.request;

import jakarta.validation.constraints.NotNull;

public record ProductPurchaseRequestDTO(

        @NotNull(message = "Product is Mandatory")
        Long productId,

        @NotNull(message = "Quantity is mandatory")
        double quantity
) {
}
