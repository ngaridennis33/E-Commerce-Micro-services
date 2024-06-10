package com.northfaceclone.userservice.service;

import com.northfaceclone.userservice.dto.request.AuthenticationRequest;
import com.northfaceclone.userservice.dto.request.UserRequestDTO;
import com.northfaceclone.userservice.dto.response.AuthenticationResponse;
import jakarta.mail.MessagingException;

public interface AuthenticationService {

    //    Register User
    void register(UserRequestDTO request) throws MessagingException;

    //    Login
    AuthenticationResponse authenticate(AuthenticationRequest request);

    // Activate Account
    void activateAccount(String token) throws MessagingException;

    //    Logout

    //    Change Password

    //    Update user details
    void updateUser(UserRequestDTO requestDTO);

    //    delete

    //    FindById

    //    Find by Username

    //    Find All users
}
