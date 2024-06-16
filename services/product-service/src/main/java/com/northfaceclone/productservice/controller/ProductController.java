package com.northfaceclone.productservice.controller;

import com.northfaceclone.productservice.dto.request.ProductPurchaseRequestDTO;
import com.northfaceclone.productservice.dto.request.ProductRequestDTO;
import com.northfaceclone.productservice.dto.response.ProductPurchaseResponseDTO;
import com.northfaceclone.productservice.dto.response.ProductResponseDTO;
import com.northfaceclone.productservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    //  Create a Product
    @PostMapping()
    public ResponseEntity<Long> createProduct(
            @RequestBody @Valid ProductRequestDTO request
    ){
        return ResponseEntity.ok(service.createProduct(request));
    }

    //  Get Products Purchased
    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponseDTO>> purchaseProduucts(
            @RequestBody List<ProductPurchaseRequestDTO> request
    ){
        return ResponseEntity.ok(service.purchaseProducts(request));
    }

    //  Get All Products
    @GetMapping("/")
    public ResponseEntity<List<ProductResponseDTO>> findAllProducts(){
        return ResponseEntity.ok(service.findAllProducts());
    }

    //  Get Product ById
    @GetMapping("/{product-id}")
    public ResponseEntity<ProductResponseDTO> findById(
            @PathVariable("product-id") Long productId
    ){
        return ResponseEntity.ok(service.findProductById(productId));
    }

    //  Update Product

    //  Get Product By Name

    //  Delete Product
}
