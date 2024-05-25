package com.northfaceclone.userservice.repository;

import com.northfaceclone.userservice.models.WishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishListRepository extends JpaRepository<WishList, Integer> {
}
