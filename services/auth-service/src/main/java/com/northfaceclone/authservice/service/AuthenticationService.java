package com.northfaceclone.authservice.service;

import com.northfaceclone.userservice.dto.request.AuthenticationRequest;
import com.northfaceclone.userservice.dto.request.AccountRequestDTO;
import com.northfaceclone.userservice.dto.response.AuthenticationResponse;
import jakarta.mail.MessagingException;

public interface AuthenticationService {

    //    Register User
    void register(AccountRequestDTO request) throws MessagingException;

    //    Login
    AuthenticationResponse authenticate(AuthenticationRequest request);

    // Activate Account
    void activateAccount(String token) throws MessagingException;

    //  Logout

    //  Password Reset

    //  Refresh Tokens
}
