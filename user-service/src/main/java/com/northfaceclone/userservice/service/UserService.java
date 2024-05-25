package com.northfaceclone.userservice.service;

import com.northfaceclone.userservice.dto.UserDTO;
import com.northfaceclone.userservice.dto.UserResponseDTO;
import com.northfaceclone.userservice.mapper.UserMapper;
import com.northfaceclone.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    // Create a New User
    public UserResponseDTO saveUser(
            UserDTO userDTO
    ) {
        var user = userMapper.toUser(userDTO);
        var savedUser = userRepository.save(user);
        return userMapper.toUserResponseDTO(savedUser);
    }

    // Get All Users
    public List<UserResponseDTO> findAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toUserResponseDTO)
                .collect(Collectors.toList());
    }

    // Get User By Id
    public UserResponseDTO findUserById(Integer id) {
        return userRepository.findById(id)
                .map(userMapper::toUserResponseDTO)
                .orElse(null);
    }

    ;
}
