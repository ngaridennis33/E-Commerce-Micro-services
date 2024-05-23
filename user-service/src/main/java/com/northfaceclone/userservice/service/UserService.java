package com.northfaceclone.userservice.service;

import com.northfaceclone.userservice.dto.WishListResponseDto;
import com.northfaceclone.userservice.models.User;
import com.northfaceclone.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public void saveUser(User user){
        repository.save(user);
    }

    public List<User> findAllUsers(){
        return repository.findAll();
    }

    public WishListResponseDto findProductsInWishList(Integer productId){
        var user = repository.findById(productId)
                .orElse(
                        User.builder()
                                .first_name("Not Found")
                                .last_name("Not Found")
                                .build()
                );
        var products = null; // Find all the Products from the product microservice

        return null;
    }
}
