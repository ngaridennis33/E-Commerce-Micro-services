package com.northfaceclone.userservice.controller;

import com.northfaceclone.userservice.dto.UserDTO;
import com.northfaceclone.userservice.dto.UserResponseDTO;
import com.northfaceclone.userservice.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    // Create a new user
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO saveUser(
            @Valid @RequestBody UserDTO dto
    ) {
        return this.userService.saveUser(dto);
    }

    // Get all users
    @GetMapping
    public List<UserResponseDTO> findAllUsers() {
        return userService.findAllUsers();
    }

    //  Get User By Id
    @GetMapping("/{user-id}")
    public UserResponseDTO findUserById(
            @PathVariable("user-id") Integer userId
    ) {
        return userService.findUserById(userId);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exp
    ){
        var errors = new HashMap<String, String>();
        exp.getBindingResult().getAllErrors()
                .forEach(error ->{
                    var fieldName = ((FieldError) error).getField();
                    var errorMessage = error.getDefaultMessage();
                    errors.put(fieldName, errorMessage);
                });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
