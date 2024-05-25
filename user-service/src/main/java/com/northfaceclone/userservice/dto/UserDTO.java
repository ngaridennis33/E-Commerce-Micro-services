package com.northfaceclone.userservice.dto;

import jakarta.validation.constraints.NotEmpty;

public record UserDTO(
        @NotEmpty(message = "First Name Should NOT be empty")
        String first_name,

        @NotEmpty(message = "Last Name should NOT be empty")
        String last_name,

        @NotEmpty(message = "Email should NOT be empty")
        String email

) {
}
