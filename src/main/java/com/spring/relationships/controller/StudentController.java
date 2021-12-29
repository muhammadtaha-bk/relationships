package com.spring.relationships.controller;

import com.spring.relationships.model.Address;
import com.spring.relationships.model.Student;
import com.spring.relationships.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService service;

    @Autowired
    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity getAllStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @PostMapping
    public String addStudent(@RequestBody Student student) {
        return service.createStudent(student);
    }

    @PutMapping("/set-add")
    public String setAddressInfo(@RequestParam(name = "student-id") Long studentId,
                                 @RequestParam(name = "address-id") Long addressId) {
        return service.setAddressInfo(studentId, addressId);
    }
}
