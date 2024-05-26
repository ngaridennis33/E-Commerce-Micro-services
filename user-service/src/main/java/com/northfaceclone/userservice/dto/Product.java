package com.northfaceclone.userservice.dto;

import com.northfaceclone.userservice.models.WishList;
import lombok.*;

//@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

//    private int id;

    private String name;

    private int price;

    private int discount;

    private String description;
}
