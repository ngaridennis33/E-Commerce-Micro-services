package com.northfaceclone.productservice.dto;

import jakarta.validation.constraints.NotEmpty;

public record ProductDTO(
        @NotEmpty(message = "First Name should NOT be empty")
        String name,

        @NotEmpty(message = "Last Name should NOT be empty")
        int price,

        int discount,

        String description
) {
}
