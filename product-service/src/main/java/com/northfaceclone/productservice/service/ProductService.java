package com.northfaceclone.productservice.service;

import com.northfaceclone.productservice.models.Products;
import com.northfaceclone.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public void saveProduct(Products user){
        productRepository.save(user);
    }

    public List<Products> findAllProducts(){
        return productRepository.findAll();
    }

    public List<Products>findAllProductsByUser(Integer userId){
        return productRepository.findAllProductsByUserId(userId);
    }
}
