package com.northfaceclone.authservice.mapper;

import com.northfaceclone.authservice.entity.Account;
import com.northfaceclone.userservice.dto.request.AccountRequestDTO;
import com.northfaceclone.authservice.dto.response.AccountResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountMapper {

    public Account toUser(AccountRequestDTO request){
        if (request == null){
            return null;
        }
        return Account.builder()
                .firstname(request.firstname())
                .lastname(request.lastname())
                .email(request.email())
                .password(request.password())
                .build();
    }

    public AccountResponseDTO fromUser(Account user){
        return new AccountResponseDTO(
                user.getId(),
                user.getFirstname(),
                user.getLastname(),
                user.getUsername(),
                user.getEmail()

        );
    }
}