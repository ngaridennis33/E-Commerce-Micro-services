package com.northfaceclone.userservice.dto.request;

public record UserDTO(
        String first_name,
        String last_name,
        String email,
        String user_name,
        String password,
        String phone,
        String avatar
) {
}
