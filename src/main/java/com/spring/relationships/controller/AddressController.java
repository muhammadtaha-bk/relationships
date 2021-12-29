package com.spring.relationships.controller;

import com.spring.relationships.model.Address;
import com.spring.relationships.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {
    private final AddressService service;

    @Autowired
    public AddressController(AddressService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity getAllAddresses(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @PostMapping
    public String addAddress(@RequestBody Address address){
        return service.createAddress(address);
    }
}
