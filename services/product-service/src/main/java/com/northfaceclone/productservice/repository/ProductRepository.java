package com.northfaceclone.productservice.repository;

import com.northfaceclone.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}