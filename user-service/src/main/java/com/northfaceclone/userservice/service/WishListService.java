package com.northfaceclone.userservice.service;

import com.northfaceclone.userservice.client.UserClient;
import com.northfaceclone.userservice.dto.FullUserResponse;
import com.northfaceclone.userservice.dto.Product;
import com.northfaceclone.userservice.dto.WishListDTO;
import com.northfaceclone.userservice.dto.WishListResponseDTO;
import com.northfaceclone.userservice.mapper.WishListMapper;
import com.northfaceclone.userservice.repository.WishListRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WishListService {

    private final WishListRepository wishListRepository;
    private final WishListMapper wishListMapper;
    private UserClient userClient;


    // Add Product to WishList
    public  WishListResponseDTO saveProduct(
            WishListDTO dto
    ){
        var product = wishListMapper.toWishList(dto);
        var savedProduct = wishListRepository.save(product);
        return wishListMapper.toWishListResponseDTO(savedProduct);
    };

    // Get Items in wishList
    public List<WishListResponseDTO> findProductsInWishList(){
        return wishListRepository.findAll()
                .stream()
                .map(wishListMapper::toWishListResponseDTO)
                .collect(Collectors.toList());
    }

    // findAllProductsInWishList
    public FullUserResponse findAllProductsInWishList(Integer productId)  {
        var product = wishListRepository.findById(productId)
                .orElse(
                        Product.builder()
                                .name("Not Found")
                                .description("Not Found")
                                .build()
                );
        var products = userClient.findAllProductsInWishList(productId);
        return products;
    };
}
