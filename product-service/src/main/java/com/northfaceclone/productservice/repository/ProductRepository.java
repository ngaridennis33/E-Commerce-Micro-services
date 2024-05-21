package com.northfaceclone.productservice.repository;

import com.northfaceclone.productservice.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Products, Integer> {
}
