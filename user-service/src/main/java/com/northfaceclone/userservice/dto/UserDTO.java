package com.northfaceclone.userservice.dto;

import jakarta.validation.constraints.NotEmpty;

public record UserDTO(
        @NotEmpty(message = "First Name Should NOT be empty")
        String firstname,

        @NotEmpty(message = "Last Name should NOT be empty")
        String lastname,

        String email

) {
}
