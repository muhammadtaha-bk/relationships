package com.spring.relationships.service;

import com.spring.relationships.model.Address;
import org.springframework.http.ResponseEntity;

public interface AddressService {
    ResponseEntity getAll();

    String createAddress(Address address);
}
