package com.northface_clone.orderservice.dto.response;

public record CustomerResponseDTO(
        Long id,
        String firstname,
        String lastname,
        String email
) {
}
