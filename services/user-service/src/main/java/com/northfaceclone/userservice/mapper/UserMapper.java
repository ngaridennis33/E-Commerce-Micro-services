package com.northfaceclone.userservice.mapper;

import com.northfaceclone.userservice.dto.request.UserRequestDTO;
import com.northfaceclone.userservice.dto.response.UserResponseDTO;
import com.northfaceclone.userservice.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserMapper {

    public User toUser(UserRequestDTO request){
        if (request == null){
            return null;
        }
        return User.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .password(request.password())
                .phoneNumber(request.phoneNumber())
                .build();
    }

    public UserResponseDTO fromUser(User user){
        return new UserResponseDTO(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getUsername(),
                user.getEmail(),
                user.getAvatar()
//                user.getAddress()
        );
    }
}