package com.northfaceclone.productservice.controller;

import com.northfaceclone.productservice.models.Products;
import com.northfaceclone.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

//    Create a new Product
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(
            @RequestBody Products product
    ){
        service.saveProduct(product);
    }

//    Get All Products
    @GetMapping
    public ResponseEntity<List<Products>> findAllUsers(){
        return ResponseEntity.ok(service.findAllProducts());
    }

    //    Get All Products
    @GetMapping("/product/{user-id}")
    public ResponseEntity<List<Products>> findAllUsers(
            @PathVariable("user-id")Integer userId
    ){
        return ResponseEntity.ok(service.findAllProductsByUser(userId));
    }
}
