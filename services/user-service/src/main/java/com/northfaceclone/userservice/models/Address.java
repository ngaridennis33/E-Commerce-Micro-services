package com.northfaceclone.userservice.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.validation.annotation.Validated;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Validated
public class Address extends BaseEntity {

    private String country;
    private String city;
    private String street;
    private String zipcode;
    private String addressLine1;
    private String addressLine2;
    private String telephone;
    private String mobile;
}
