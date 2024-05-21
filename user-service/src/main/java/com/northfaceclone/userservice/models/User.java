package com.northfaceclone.userservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "customers")
public class User {

    @Id
    private Integer id;

    private String first_name;

    private String last_name;

    private String email;

    private Integer Address;

}
