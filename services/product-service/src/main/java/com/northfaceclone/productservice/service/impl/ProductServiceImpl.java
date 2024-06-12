package com.northfaceclone.productservice.service.impl;

import com.northfaceclone.productservice.dto.request.ProductPurchaseRequestDTO;
import com.northfaceclone.productservice.dto.request.ProductRequestDTO;
import com.northfaceclone.productservice.dto.response.ProductPurchaseResponseDTO;
import com.northfaceclone.productservice.dto.response.ProductResponseDTO;
import com.northfaceclone.productservice.exception.ProductPurchaseException;
import com.northfaceclone.productservice.mapper.ProductMapper;
import com.northfaceclone.productservice.repository.ProductRepository;
import com.northfaceclone.productservice.service.ProductService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    /**
     * Creates a new Product based on the request
     *
     * @param request - The request with the info about the product
     * @return - The ID of the newly created Product
     */
    public Long createProduct(ProductRequestDTO request) {
        var product = mapper.toProduct(request);
        return repository.save(product).getId();
    }


    /**
     * Finds all products requested for purchase and process the purchase
     *
     * @param request - A list of ProductPurchaseDTO containing IDS and Quantities
     * @return - A list of ProductPurchaseResponseDTO representing purchased products
     * @throws ProductPurchaseException if one or more products do not exist or if there's insufficient stock
     */
    public List<ProductPurchaseResponseDTO> purchaseProducts(List<ProductPurchaseRequestDTO> request) {

        //  Extract the Product Ids from the request and create a list.
        var productIds = request
                .stream()
                .map(ProductPurchaseRequestDTO::productId)
                .toList();

        //  Check if the Products with the list of IDs passed exist.
        var storedProducts = repository.findAllByIdInOrderById(productIds);
        if (productIds.size() != storedProducts.size()) {
            throw new ProductPurchaseException("One or more products does not exist");
        }

        //  If products are available, Sort the purchase requests by product ID
        var storedRequest = request
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequestDTO::productId))
                .toList();

        //  Process the Purchase of each product.
        var purchasedProducts = new ArrayList<ProductPurchaseResponseDTO>();
        for (int i = 0; i < storedProducts.size(); i++) {
            var product = storedProducts.get(i);
            var productRequest = storedRequest.get(i);

            //  Check if the stock is sufficient
            if (product.getAvailableQuantity() < productRequest.quantity()) {
                throw new ProductPurchaseException("Insufficient stock quantity for product with ID:: " + productRequest.productId());
            }

            //  Update available quantity of the product
            var newAvailableQuantity = product.getAvailableQuantity() - productRequest.quantity();
            product.setAvailableQuantity(newAvailableQuantity);
            repository.save(product);

            //  Create a response DTO for the purchased product and map it
            purchasedProducts.add(mapper.toProductPurchaseResponse(product, productRequest.quantity()));
        }
        return purchasedProducts;
    }

    //  Find All Products
    public List<ProductResponseDTO> findAllProducts() {
        return repository.findAll()
                .stream()
                .map(mapper::toProductResponse)
                .collect(Collectors.toList());
    }

    //  Find Product By ID
    public ProductResponseDTO findProductById(Long productId) {
        return repository.findById(productId)
                .map(mapper::toProductResponse)
                .orElseThrow(() -> new EntityNotFoundException("Product not found with the ID:: " + productId));
    }


}
