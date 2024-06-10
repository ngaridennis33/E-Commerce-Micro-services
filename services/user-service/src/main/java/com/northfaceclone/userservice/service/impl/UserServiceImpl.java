package com.northfaceclone.userservice.service.impl;

import com.northfaceclone.userservice.dto.request.ResetPasswordRequestDTO;
import com.northfaceclone.userservice.dto.request.UserRequestDTO;
import com.northfaceclone.userservice.dto.response.UserResponseDTO;
import com.northfaceclone.userservice.mapper.UserMapper;
import com.northfaceclone.userservice.models.User;
import com.northfaceclone.userservice.repository.UserRepository;
import com.northfaceclone.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper mapper;

    // List All Users
    public List<UserResponseDTO> findAllUsers(){

        return repository.findAll()
                .stream()
                .map(mapper::fromUser)
                .collect(Collectors.toList());
    }

    //  Verify User Existence by ID
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
//        if(request.address() != null){
//            user.setAddress(request.address());
//        }
    }

    //  Find user by name
    public List<UserResponseDTO> findUserByName(String name){
        return repository.findAllByFirstnameContaining(name)
                .stream()
                .map(mapper::fromUser)
                .collect(Collectors.toList());
    }

    //  Update User Password
    public void updateUserPassword(ResetPasswordRequestDTO request){
        var user = repository.findById(request.id())
                .orElseThrow(()-> new RuntimeException(
                        String.format("Cannot update user:: No User Found with the provided ID:: %s", request.id())
                ));
        updatePassword(user, request);
        repository.save(user);
    }

    private void updatePassword(User user, ResetPasswordRequestDTO request ){
        String password = request.password();
        String confirmPassword = request.confirmPassword();

        if (StringUtils.isNotBlank(password) && StringUtils.isNotBlank(confirmPassword) && password.equals(confirmPassword)) {
            user.setPassword(passwordEncoder.encode(password));
        } else {
            throw new IllegalArgumentException("Passwords do not match");
        }
    }

    //  Delete User By ID
    public void deleteUserById(Long userId){
        repository.deleteById(userId);

    }
}
