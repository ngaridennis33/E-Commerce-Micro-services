package com.northfaceclone.userservice.dto.response;

import com.northfaceclone.userservice.models.Address;

public record UserResponseDTO(
        Long id,
        String firstname,
        String lastname,
        String username,
        String email,
        String avatar,
        Address address
) {
}
