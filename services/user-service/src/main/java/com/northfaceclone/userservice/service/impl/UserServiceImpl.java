package com.northfaceclone.userservice.service.impl;

import com.northfaceclone.userservice.dto.request.UserRequestDTO;
import com.northfaceclone.userservice.dto.response.UserResponseDTO;
import com.northfaceclone.userservice.mapper.UserMapper;
import com.northfaceclone.userservice.models.User;
import com.northfaceclone.userservice.repository.UserRepository;
import com.northfaceclone.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private UserMapper mapper;

    // List All Users
    public List<UserResponseDTO> findAllUsers(){

        return repository.findAll()
                .stream()
                .map(mapper::fromUser)
                .collect(Collectors.toList());
    }

    public Boolean existsById(Long userId){
        return repository.findById(userId)
                .isPresent();
    }

    //  Find User by ID
    public UserResponseDTO findUserById(Long userId){
      return repository.findById(userId)
              .map(mapper::fromUser)
              .orElseThrow(()-> new RuntimeException(String.format("No User found with the provided ID:: %s", userId)));
    }

    //  Update user By ID
    public void updateUser(UserRequestDTO request){
        var user = repository.findById(request.id())
                .orElseThrow(()-> new RuntimeException(
                        String.format("Cannot update user:: No User Found with the provided ID:: %s", request.id())
                ));
        mergeUser(user, request);
        repository.save(user);
    }

    private void mergeUser(User user, UserRequestDTO request){
        if(StringUtils.isNotBlank(request.firstname())){
            user.setFirstname(request.firstname());
        }
        if(StringUtils.isNotBlank(request.lastname())){
            user.setFirstname(request.lastname());
        }
        if(StringUtils.isNotBlank(request.email())){
            user.setFirstname(request.email());
        }
        if(request.address() != null){
            user.setAddress(request.address());
        }
    }

    //  Delete User By ID
    public void deleteUserById(Long userId){
        repository.deleteById(userId);

    }


}
