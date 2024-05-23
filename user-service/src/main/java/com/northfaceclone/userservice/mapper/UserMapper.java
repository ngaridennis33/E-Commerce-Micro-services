package com.northfaceclone.userservice.mapper;

import com.northfaceclone.userservice.dto.UserResponseDTO;
import com.northfaceclone.userservice.models.User;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public User toUser(UserResponseDTO dto){
        if(dto == null){
            throw new NullPointerException("The student DTO should NOT be null");
        }
        var user = new User();
        user.setFirst_name(dto.firstname());
        user.setLast_name(dto.lastname());
        user.setEmail(dto.email());

        return user;
    };

    public UserResponseDTO toUserResponseDTO(User user){
        return new UserResponseDTO(
                user.getFirst_name(),
                user.getLast_name(),
                user.getEmail()
        );
    }
}
