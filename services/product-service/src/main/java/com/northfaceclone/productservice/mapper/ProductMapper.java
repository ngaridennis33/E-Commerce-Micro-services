package com.northfaceclone.productservice.mapper;

import com.northfaceclone.productservice.dto.ProductDTO;
import com.northfaceclone.productservice.dto.ProductResponseDTO;
import com.northfaceclone.productservice.models.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product toProduct(ProductDTO dto){
        if(dto == null){
            throw new NullPointerException("The student DTO should NOT be null");
        }
        var product = new Product();
        product.setName(dto.name());
        product.setPrice(dto.price());
        product.setDescription(dto.description());
        product.setDiscount(dto.discount());

        return product;
    }
    public ProductResponseDTO toProductResponseDTO(Product product){
        return new ProductResponseDTO(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getDiscount(),
                product.getDescription()
        );
    }
}
