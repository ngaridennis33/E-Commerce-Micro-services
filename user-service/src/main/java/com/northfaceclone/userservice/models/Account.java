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
@Entity(name = "account")
public class Account extends BaseEntity {

    private String user_id;

    private String provider;

    private String provider_account_id;

    private String access_token;

    private String refresh_token;

    private LocalDateTime expires_at;

}
