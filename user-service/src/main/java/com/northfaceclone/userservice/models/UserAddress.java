package com.northfaceclone.userservice.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity(name = "user_address")
public class UserAddress extends BaseEntity {

    private String user_id;

    private String address_line1;

    private String address_line2;

    private String city;

    private String country;

    private String telephone;

    private String mobile;

}
