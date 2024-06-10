package com.northfaceclone.userservice.service;

import com.northfaceclone.userservice.dto.request.AuthenticationRequest;
import com.northfaceclone.userservice.dto.request.UserRequestDTO;
import com.northfaceclone.userservice.dto.response.AuthenticationResponse;
import com.northfaceclone.userservice.dto.response.UserResponseDTO;
import jakarta.mail.MessagingException;

import java.util.List;

public interface AuthenticationService {

    //    Register User
    void register(UserRequestDTO request) throws MessagingException;

    //    Login
    AuthenticationResponse authenticate(AuthenticationRequest request);

    // Activate Account
    void activateAccount(String token) throws MessagingException;

    //  Logout

    //  Password Reset

    //  Refresh Tokens
}
