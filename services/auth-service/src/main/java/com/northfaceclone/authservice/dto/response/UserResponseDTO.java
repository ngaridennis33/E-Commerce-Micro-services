package com.northfaceclone.authservice.dto.response;

public record UserResponseDTO(
        Integer id,
        String firstname,
        String lastname,
        String username,
        String email
) {
}
