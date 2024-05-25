package com.northfaceclone.userservice.dto;

import com.northfaceclone.userservice.models.WishList;

import java.util.List;

public record UserResponseDTO(
        String first_name,
        String last_name,
        String email
) {
}
