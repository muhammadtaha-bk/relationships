package com.spring.relationships.service;

import com.spring.relationships.model.Address;
import com.spring.relationships.model.Student;
import org.springframework.http.ResponseEntity;

public interface StudentService {
    ResponseEntity getAll();

    String createStudent(Student student);

    String setAddressInfo(Long studentId, Long addressId);
}
