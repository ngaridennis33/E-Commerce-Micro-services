package com.northfaceclone.userservice.dto.response;

import com.northfaceclone.userservice.dto.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FullUserResponse {

    private String name;
    private String email;

    List<Product> products;
}
