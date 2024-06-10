package com.northfaceclone.userservice.service;

import com.northfaceclone.userservice.dto.request.ResetPasswordRequestDTO;
import com.northfaceclone.userservice.dto.request.UserRequestDTO;
import com.northfaceclone.userservice.dto.response.UserResponseDTO;

import java.util.List;

public interface UserService {

    //  Find all Users
    List<UserResponseDTO> findAllUsers();

    //  Check if User exists
    Boolean existsById(Long id);

    //  Find User By Id
    UserResponseDTO findUserById(Long userId);

    // Update User Details
    void updateUser(UserRequestDTO requestDTO);

    //  Find User by name
    List<UserResponseDTO> findUserByName(String name);

    //  Change User Password
    void updateUserPassword(ResetPasswordRequestDTO request);

    //  Delete User
    void deleteUserById(Long userId);

}
