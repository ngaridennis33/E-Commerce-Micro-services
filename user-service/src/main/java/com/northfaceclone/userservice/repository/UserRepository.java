package com.northfaceclone.userservice.repository;

import com.northfaceclone.userservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
