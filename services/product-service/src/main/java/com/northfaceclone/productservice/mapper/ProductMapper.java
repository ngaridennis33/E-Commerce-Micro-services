package com.northfaceclone.productservice.mapper;

import com.northfaceclone.productservice.dto.request.ProductRequestDTO;
import com.northfaceclone.productservice.dto.response.ProductPurchaseResponseDTO;
import com.northfaceclone.productservice.dto.response.ProductResponseDTO;
import com.northfaceclone.productservice.models.Category;
import com.northfaceclone.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductMapper {

    public Product toProduct(ProductRequestDTO request){
        return Product.builder()
                .id(request.id())
                .name(request.name())
                .description(request.description())
                .price(request.price())
                .availableQuantity(request.availableQuantity())
                .category(Category.builder()
                        .id(request.categoryId())
                        .build())
                .build();
    }

    public ProductResponseDTO toProductResponse(Product product){
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getAvailableQuantity(),
                product.getPrice(),
                product.getCategory().getId(),
                product.getCategory().getName(),
                product.getCategory().getDescription()
        );
    }

    public ProductPurchaseResponseDTO toProductPurchaseResponse(Product product, double quantity){
        return new ProductPurchaseResponseDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                quantity
        );
    }
}
