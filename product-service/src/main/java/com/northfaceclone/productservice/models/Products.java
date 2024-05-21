package com.northfaceclone.productservice.models;

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
@Entity(name = "products")
public class Products extends BaseEntity {

    private String name;

    private String desc;

    private int sub_category_id;

    private int inventory_id;

    private int price;

    private int discount_id;

}
