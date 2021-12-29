package com.spring.relationships.service.implimentation;

import com.spring.relationships.model.Address;
import com.spring.relationships.model.Student;
import com.spring.relationships.repository.AddressRepository;
import com.spring.relationships.repository.StudentRepository;
import com.spring.relationships.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository repository;
    private final AddressRepository addressRepo;

    @Autowired
    public StudentServiceImpl(StudentRepository repository, AddressRepository addressRepo) {
        this.repository = repository;
        this.addressRepo = addressRepo;
    }

    @Override
    public ResponseEntity getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @Override
    public String createStudent(Student student) {
        repository.save(student);
        return "Student added \u2713";
    }

    @Override
    public String setAddressInfo(Long studentId, Long addressId) {
        Student student = repository.findById(studentId).get();
        Address address = addressRepo.findById(addressId).get();

        student.setAddress(address);
        repository.save(student);
        return "Address settled \u2713";
    }
}
