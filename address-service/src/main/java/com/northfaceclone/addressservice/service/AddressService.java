package com.northfaceclone.addressservice.service;

import com.northfaceclone.addressservice.models.Address;
import com.northfaceclone.addressservice.repository.AddressRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository repository;

    public void saveAddress(Address address){
        repository.save(address);
    }

    public List<Address> findAllAddresses(){
        return repository.findAll();
    }
}
