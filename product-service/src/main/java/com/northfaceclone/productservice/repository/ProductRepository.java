package com.northfaceclone.productservice.repository;

import com.northfaceclone.productservice.models.Products;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Products, Integer> {

    List<Products> findAllProductsByUserId(Integer userId);
}
