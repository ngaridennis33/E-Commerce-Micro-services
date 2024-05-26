package com.northfaceclone.userservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.NaturalId;


@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "customers")
public class User extends BaseEntity {

    @NotBlank(message = "First Name Should NOT be blank")
    @Size(min = 3, max = 30, message = "First Name must be between 3 and 30 characters")
    @Column(name = "firstName")
    private String first_name;

    @NotBlank(message = "Last Name Should NOT be blank")
    @Size(min = 3, max = 30, message = "Last Name must be between 3 and 30 characters")
    @Column(name = "lastName")
    private String last_name;

    @NaturalId
    @NotBlank(message = "Email Should NOT be blank")
    @Size(max = 50)
    @Email(message = "Input must be in Email format")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Password must not be blank")
    @Size(min = 6, max = 10, message = "Password must be between 8 and 10 characters")
    @Column(name = "password")
    private String password;

    @Size(min = 3, max = 30, message = "User Name must be between 3 and 30 characters")
    @Column(name = "userName")
    private String user_name;

    @NotBlank(message = "Phone Number Should NOT be blank")
    @Pattern(regexp = "^\\+84[0-9]{9,10}$|^0[0-9]{9,10}$", message = "The phone number is not in the correct format")
    @Size(min = 10, max = 11, message = "Phone number must be between 10 and 11 characters")
    @Column(name = "phoneNumber", unique = true)
    private String phone_number;

    @Pattern(regexp = "^(http|https)://.*$", message = "Avatar URL must be a valid HTTP or HTTPS URL")
    @Column(name = "imageUrl")
    private String avatar;
}
