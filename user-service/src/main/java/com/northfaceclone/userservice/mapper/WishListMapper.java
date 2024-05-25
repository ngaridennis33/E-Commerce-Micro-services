package com.northfaceclone.userservice.mapper;

import com.northfaceclone.userservice.dto.Product;
import com.northfaceclone.userservice.dto.WishListDTO;
import com.northfaceclone.userservice.dto.WishListResponseDTO;
import com.northfaceclone.userservice.models.User;
import com.northfaceclone.userservice.models.WishList;
import org.springframework.stereotype.Service;

@Service
public class WishListMapper {
    public WishList toWishList(WishListDTO dto){
        if(dto == null){
            throw new NullPointerException("The student DTO should NOT be null");
        }
        var userWish = new WishList();
        userWish.setProduct_id(dto.product_id());

        var user = new User();
        user.setId(dto.user_id());
        userWish.setUser(user);

        return userWish;
    }
    public WishListResponseDTO toWishListResponseDTO(WishList wishList){
        return new WishListResponseDTO(
                wishList.getId(),
                wishList.getProduct_id()

        );
    }

}