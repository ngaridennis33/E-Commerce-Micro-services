package com.northfaceclone.userservice.client;

import com.northfaceclone.userservice.dto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "user-service", url = "${application.config.user-url}")
public interface UserClient {

    @GetMapping("/wishList/{product-id}")
    List<Product> findAllProductsInWishList(@PathVariable("product-id") Integer productId);
}