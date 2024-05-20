package com.northfaceclone.userservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    private Integer id;

    private String first_name;

    private String last_name;

    private String email;

    private Integer Address;

}
