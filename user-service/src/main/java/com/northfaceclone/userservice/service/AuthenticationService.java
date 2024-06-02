package com.northfaceclone.userservice.service;

import com.northfaceclone.userservice.dto.request.AuthenticationRequest;
import com.northfaceclone.userservice.dto.request.AuthenticationResponse;
import com.northfaceclone.userservice.dto.request.RegistrationRequest;
import jakarta.mail.MessagingException;

public interface AuthenticationService {

    //    Register User
    void register(RegistrationRequest request) throws MessagingException;

    //    Login
    AuthenticationResponse authenticate(AuthenticationRequest request);

    //    Logout

    //    Change Password

    //    delete

    //    FindById

    //    Find by Username

    //    Find All users
}
