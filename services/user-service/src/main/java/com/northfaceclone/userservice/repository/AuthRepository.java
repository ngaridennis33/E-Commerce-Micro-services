package com.northfaceclone.userservice.repository;

import com.northfaceclone.userservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
