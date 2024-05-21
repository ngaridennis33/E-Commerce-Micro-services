package com.northfaceclone.addressservice.repository;

import com.northfaceclone.addressservice.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
