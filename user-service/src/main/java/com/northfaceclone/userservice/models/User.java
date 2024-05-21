package com.northfaceclone.userservice.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity(name = "customers")
public class User extends BaseEntity {

    private String first_name;

    private String last_name;

    private String email;

    private String password;

    private String username;

    private String phone_number;

    private String provider;

    private Boolean verified;

    private String verification_code;

    private LocalDateTime date_of_birth;

    private String password_reset_token;

    private String avatar;

    private Integer address;
}
