package com.northfaceclone.userservice.models;

import com.northfaceclone.userservice.dto.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
public class Address extends BaseEntity {

    private String city;
    private String country;
    private String addressLine1;
    private String addressLine2;
    private String telephone;
    private String mobile;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
}
