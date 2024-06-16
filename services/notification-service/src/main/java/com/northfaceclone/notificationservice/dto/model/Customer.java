package com.northfaceclone.notificationservice.dto.model;

public record Customer(
        Long id,
        String firstname,
        String lastname,
        String email
) {
}
