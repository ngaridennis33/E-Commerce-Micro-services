package com.northfaceclone.authservice.mapper;

import com.northfaceclone.authservice.entity.User;
import com.northfaceclone.userservice.dto.request.UserRequestDTO;
import com.northfaceclone.authservice.dto.response.UserResponseDTO;
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
        );
    }
}