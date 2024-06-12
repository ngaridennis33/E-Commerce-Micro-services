package com.northfaceclone.productservice.service;

import com.northfaceclone.productservice.dto.request.ProductPurchaseRequestDTO;
import com.northfaceclone.productservice.dto.request.ProductRequestDTO;
import com.northfaceclone.productservice.dto.response.ProductPurchaseResponseDTO;
import com.northfaceclone.productservice.dto.response.ProductResponseDTO;
import com.northfaceclone.productservice.repository.ProductRepository;

import java.util.List;

public interface ProductService {

    //  Create a Product
    Long createProduct(ProductRequestDTO request);

    //  find All Products
    List<ProductResponseDTO> findAllProducts();

    //  Find products purchased
    List<ProductPurchaseResponseDTO> purchaseProducts(List<ProductPurchaseRequestDTO> request);

    //  find Product ById
    ProductResponseDTO findProductById(Long productId);

    //  Update Product

    //  find Product By Name

    //  Delete Product
}
