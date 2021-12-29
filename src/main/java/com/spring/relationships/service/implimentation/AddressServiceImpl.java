package com.spring.relationships.service.implimentation;

import com.spring.relationships.model.Address;
import com.spring.relationships.repository.AddressRepository;
import com.spring.relationships.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository repository;

    @Autowired
    public AddressServiceImpl(AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @Override
    public String createAddress(Address address) {
        repository.save(address);
        return "Address added \u2713";
    }
}
