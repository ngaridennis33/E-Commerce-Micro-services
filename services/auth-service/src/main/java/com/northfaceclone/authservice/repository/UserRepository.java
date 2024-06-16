package com.northfaceclone.authservice.repository;

import com.northfaceclone.authservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByFirstnameContaining(String p);

}
