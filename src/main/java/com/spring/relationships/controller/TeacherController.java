package com.spring.relationships.controller;

import com.spring.relationships.model.Teacher;
import com.spring.relationships.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService service;

    @Autowired
    public TeacherController(TeacherService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity getAllTeachers(){
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @PostMapping
    public String addTeacher(@RequestBody Teacher teacher){
        return service.createTeacher(teacher);
    }
}
