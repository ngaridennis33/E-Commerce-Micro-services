package com.northfaceclone.userservice.controller;

import com.northfaceclone.userservice.dto.Product;
import com.northfaceclone.userservice.dto.WishListDTO;
import com.northfaceclone.userservice.dto.WishListResponseDTO;
import com.northfaceclone.userservice.service.WishListService;
import feign.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users/wish-list")
public class WishListController {

    private final WishListService wishListService;

    //  Add a product to wishList
    @PostMapping
    public WishListResponseDTO saveProduct(
            @RequestBody WishListDTO dto
    ) {
        return wishListService.saveProduct(dto);
    }

    // Get All products in the WishList
    @GetMapping
    public List<WishListResponseDTO> findProductsInWishList(){
        return wishListService.findProductsInWishList();
    }

    // Get All products in the WishList from Products Microservice
    @GetMapping("/{product-id}")
    public ResponseEntity<List<Product>> findAllProductsInWishList(
            @PathVariable("product-id")Integer productId
    ){
        return ResponseEntity.ok(wishListService.findAllProductsInWishList(productId));
    }

}
