package com.northfaceclone.userservice.dto.response;

public record UserResponseDTO(
        Long id,
        String first_name,
        String last_name,
        String user_name,
        String email,
        String avatar
) {
}
