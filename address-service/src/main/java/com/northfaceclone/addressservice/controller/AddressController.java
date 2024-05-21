package com.northfaceclone.addressservice.controller;


import com.northfaceclone.addressservice.models.Address;
import com.northfaceclone.addressservice.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(
            @RequestBody Address user
    ){
        service.saveAddress(user);
    }

    @GetMapping
    public ResponseEntity<List<Address>> findAllUsers(){
        return ResponseEntity.ok(service.findAllAddresses());
    }
}
