package com.northfaceclone.userservice.dto.request;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationRequest {

    @NotEmpty(message = "Firstname is mandatory")
    @NotBlank(message = "Firstname is mandatory")
    @Size(min = 3, max = 30, message = "First Name must be between 3 and 30 characters")
    private String firstname;

    @NotEmpty(message = "LastName is mandatory")
    @NotBlank(message = "Last Name is mandatory")
    @Size(min = 3, max = 30, message = "Last Name must be between 3 and 30 characters")
    private String lastname;

    @NotEmpty(message = "Email is mandatory")
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email is not formatted")
    @Size(max = 50)
    private String email;

    @NotEmpty(message = "Password is mandatory")
    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, message = "Password should have 8 characters minimum")
    private String password;

    @Pattern(regexp = "^\\+84[0-9]{9,10}$|^0[0-9]{9,10}$", message = "The phone number is not in the correct format")
    @Size(min = 10, max = 11, message = "Phone number must be between 10 and 11 characters")
    private String phoneNumber;
}
