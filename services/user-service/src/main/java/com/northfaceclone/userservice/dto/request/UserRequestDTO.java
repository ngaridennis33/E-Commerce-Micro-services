package com.northfaceclone.userservice.dto.request;

import com.northfaceclone.userservice.models.Address;
import jakarta.validation.constraints.*;

public record UserRequestDTO(
        Long id,

        @NotEmpty(message = "Firstname is mandatory")
        @NotBlank(message = "Firstname is mandatory")
        @Size(min = 3, max = 30, message = "First Name must be between 3 and 30 characters")
        String firstname,

        @NotEmpty(message = "LastName is mandatory")
        @NotBlank(message = "Last Name is mandatory")
        @Size(min = 3, max = 30, message = "Last Name must be between 3 and 30 characters")
        String lastname,

        @NotEmpty(message = "Email is mandatory")
        @NotBlank(message = "Email is mandatory")
        @Email(message = "Email is not a valid email address")
        @Size(max = 50)
        String email,

        @NotEmpty(message = "Password is mandatory")
        @NotBlank(message = "Password is mandatory")
        @Size(min = 8, message = "Password should have 8 characters minimum")
        String password,

        @Pattern(regexp = "^\\+84\\d{9,10}$|^0\\d{9,10}$", message = "The phone number is not in the correct format")
        @Size(min = 10, max = 11, message = "Phone number must be between 10 and 11 characters")
        String phoneNumber,

        Address address
) {
}

