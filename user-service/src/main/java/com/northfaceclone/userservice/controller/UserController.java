package com.northfaceclone.userservice.controller;

import com.northfaceclone.userservice.dto.WishListResponseDto;
import com.northfaceclone.userservice.models.User;
import com.northfaceclone.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;

//    Create a new user
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(
            @RequestBody User user
    ){
        service.saveUser(user);
    }

//    Get all users
    @GetMapping
    public ResponseEntity<List<User>> findAllUsers(){
        return ResponseEntity.ok(service.findAllUsers());
    }

//    Get All products in the wish list
    @GetMapping("with-product/{product-id")
    public ResponseEntity<WishListResponseDto> findProductsInWishList(
            @PathVariable("product-id") Integer productId
    ){
        return ResponseEntity.ok(service.findProductsInWishList(productId));
    }
}
