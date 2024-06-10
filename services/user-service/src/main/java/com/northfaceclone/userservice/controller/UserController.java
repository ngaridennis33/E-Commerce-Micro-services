package com.northfaceclone.userservice.controller;


import com.northfaceclone.userservice.dto.request.UserRequestDTO;
import com.northfaceclone.userservice.dto.response.UserResponseDTO;
import com.northfaceclone.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController {

    private final UserService service;

    //  Get All Users
    @GetMapping("/")
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        return ResponseEntity.ok(service.findAllUsers());
    }

    //  Verify whether a user with a specific ID exists
    @GetMapping("/user/{user-id}")
    public ResponseEntity<Boolean> existsById(
            @PathVariable("user-id") Long userId
    ) {
        return ResponseEntity.ok(service.existsById(userId));
    }

    //  Get User by ID
    @GetMapping("/user/{user-id}")
    public ResponseEntity<UserResponseDTO> findUserById(
            @PathVariable("user-id") Long userId
    ) {
        return ResponseEntity.ok(service.findUserById(userId));
    }

    //  Update User
    @PostMapping("/update")
    public ResponseEntity<Void> updateUser(
            @RequestBody @Valid UserRequestDTO request
    ) {
        service.updateUser(request);
        return ResponseEntity.accepted().build();
    }

    //  Delete User By ID
    @DeleteMapping("/delete/{user-id}")
    public ResponseEntity<Void> deleteUserById(
            @PathVariable("user-id") Long userId
    ) {
        service.deleteUserById(userId);
        return ResponseEntity.accepted().build();
    }
}