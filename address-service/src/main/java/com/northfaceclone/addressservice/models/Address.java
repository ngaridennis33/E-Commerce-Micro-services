package com.northfaceclone.addressservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {

    @Id
    private Integer id;

    private String address_line1;

    private String city;

    private String country;
}
