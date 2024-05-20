package com.northfaceclone.userservice.service;

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
}
