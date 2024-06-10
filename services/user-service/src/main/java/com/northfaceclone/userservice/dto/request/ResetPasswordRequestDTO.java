package com.northfaceclone.userservice.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record ResetPasswordRequestDTO(

        @NotBlank(message = "ID Cannot be Empty")
        @NotEmpty(message = "ID Cannot be Empty")
        Long id,

        @NotBlank(message = "Password is mandatory")
        @Size(min = 6, message = "Password must be more than 6 characters")
        String password,

        @NotBlank(message = "You must confirm password")
        String confirmPassword
) {
}
