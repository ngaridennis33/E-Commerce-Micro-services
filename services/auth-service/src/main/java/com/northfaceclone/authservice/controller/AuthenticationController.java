package com.northfaceclone.authservice.controller;

import com.northfaceclone.userservice.dto.request.AuthenticationRequest;
import com.northfaceclone.userservice.dto.request.AccountRequestDTO;
import com.northfaceclone.userservice.dto.response.AuthenticationResponse;
import com.northfaceclone.userservice.service.AuthenticationService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication")
public class AuthenticationController {

    private final AuthenticationService service;

    // Register A new User
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Void> register(
            @RequestBody @Valid AccountRequestDTO request
    ) throws MessagingException {
        service.register(request);
        return ResponseEntity.accepted().build();
    }

    //  Activate User Account
    @PostMapping("/activate-account")
    public void confirm(
            @RequestParam String token
    ) throws MessagingException {
        service.activateAccount(token);
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody @Valid AuthenticationRequest request
    ){
        return ResponseEntity.ok(service.authenticate(request));
    }

}