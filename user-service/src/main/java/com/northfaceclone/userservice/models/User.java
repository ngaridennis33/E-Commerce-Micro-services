package com.northfaceclone.userservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.northfaceclone.userservice.dto.WishListResponseDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;
import java.util.List;

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

    private String user_name;

    private String phone_number;

    private String provider;

//    @OneToMany(mappedBy = "user")
//    @JsonManagedReference
//    private List<WishList> wishLists;

    private Boolean verified;

    private String verification_code;

    private LocalDateTime date_of_birth;

    private String password_reset_token;

    private String avatar;

}
