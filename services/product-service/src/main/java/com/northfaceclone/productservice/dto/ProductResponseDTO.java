package com.northfaceclone.productservice.dto;

public record ProductResponseDTO(

        int id,

        String name,

        int price,

        int discount,

        String description
) {
}