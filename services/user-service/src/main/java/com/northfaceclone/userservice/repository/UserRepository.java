package com.northfaceclone.userservice.repository;

import com.northfaceclone.userservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByFirstnameContaining(String p);

}
