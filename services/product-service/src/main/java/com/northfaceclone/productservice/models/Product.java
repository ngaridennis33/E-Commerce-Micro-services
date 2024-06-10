package com.northfaceclone.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity()
public class Product extends BaseEntity {

    private String name;
    private String description;
    private double availableQuantity;
    private BigDecimal price;
    private int discount;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
}
