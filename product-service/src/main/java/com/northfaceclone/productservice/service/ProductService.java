package com.northfaceclone.productservice.service;

import com.northfaceclone.productservice.dto.ProductDTO;
import com.northfaceclone.productservice.dto.ProductResponseDTO;
import com.northfaceclone.productservice.mapper.ProductMapper;
import com.northfaceclone.productservice.models.Product;
import com.northfaceclone.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    // Create a new Product
    public ProductDTO create(ProductDTO dto){
       var product = productMapper.toProduct(dto);
        productRepository.save(product);
        return dto;
    }

    // Get All Products
    public List<ProductResponseDTO> findAllProducts(){
        return productRepository.findAll()
                .stream()
                .map(productMapper::toProductResponseDTO)
                .collect(Collectors.toList());
    }

    // Find Product By ID
    public ProductResponseDTO findAllProductsById(Integer id){
        return productRepository.findById(id)
                .map(productMapper::toProductResponseDTO)
                .orElse(null);
    }

    // Find All Products in a wishList
    public List <ProductResponseDTO> findAllProductsByWishList(Integer id){
        return productRepository.findById(id)
                .stream()
                .map(productMapper::toProductResponseDTO)
                .collect(Collectors.toList());
    }

}
