package com.northfaceclone.productservice.controller;

import com.northfaceclone.productservice.dto.ProductDTO;
import com.northfaceclone.productservice.dto.ProductResponseDTO;
import com.northfaceclone.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api/vi/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    // Create a new Product
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDTO saveProduct(
            @RequestBody ProductDTO dto
    ){
        return productService.create(dto);
    }

    // Get All Products
    @GetMapping
    public List<ProductResponseDTO> findAllProducts(){
        return productService.findAllProducts();
    }

    //  Get Product By ID
    @GetMapping("/{product-id}")
    public ProductResponseDTO findProductById(
            @PathVariable("product-id") Integer id
    ) {
        return productService.findAllProductsById(id);
    }

    //  Get All Products by WishList
    @GetMapping("/wishList/{product-id}")
    public List<ProductResponseDTO> findAllProductsByWishList(
            @PathVariable("product-id") Integer id
    ) {
        return productService.findAllProductsByWishList(id);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exp
    ){
        var errors = new HashMap<>();
        exp.getBindingResult().getAllErrors()
                .forEach(error -> {
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
