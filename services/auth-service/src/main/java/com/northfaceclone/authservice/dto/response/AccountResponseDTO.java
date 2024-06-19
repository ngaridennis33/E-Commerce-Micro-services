package com.northfaceclone.authservice.dto.response;

public record AccountResponseDTO(
        Integer id,
        String firstname,
        String lastname,
        String username,
        String email,
        String avatar
) {
}
