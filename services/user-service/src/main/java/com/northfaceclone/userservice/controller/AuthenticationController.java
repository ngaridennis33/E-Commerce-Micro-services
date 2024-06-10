package com.northfaceclone.userservice.controller;

import com.northfaceclone.userservice.dto.request.AuthenticationRequest;
import com.northfaceclone.userservice.dto.request.UserRequestDTO;
import com.northfaceclone.userservice.dto.response.AuthenticationResponse;
import com.northfaceclone.userservice.dto.response.UserResponseDTO;
import com.northfaceclone.userservice.service.AuthenticationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
@Tag(name = "Authentication")
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> register(
            @RequestBody @Valid UserRequestDTO request
    ) throws MessagingException {
        service.register(request);
        return ResponseEntity.accepted().build();
    }


    @PostMapping("/activate-account")
    public void confirm(
            @RequestParam String token
    ) throws MessagingException {
        service.activateAccount(token);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody @Valid AuthenticationRequest request
    ){
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/update")
    public ResponseEntity<Void> updateUser(
            @RequestBody @Valid UserRequestDTO request
    ){
        service.updateUser(request);
        return ResponseEntity.accepted().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<UserResponseDTO>> findAll(){
        return ResponseEntity.ok(service.findAllUsers());
    }
}