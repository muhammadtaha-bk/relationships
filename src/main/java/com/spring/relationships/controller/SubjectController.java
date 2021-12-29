package com.spring.relationships.controller;

import com.spring.relationships.model.Subject;
import com.spring.relationships.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    private final SubjectService service;

    @Autowired
    public SubjectController(SubjectService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity getAllSubjects() {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAll());
    }

    @PostMapping
    public String addSubject(@RequestBody Subject subject) {
        return service.createSubject(subject);
    }

    @PutMapping("/enroll")
    public String enrollStudentToSubject(@RequestParam(name = "subject-id") Long subjectId,
                                         @RequestParam(name = "student-id") Long studentId) {
        return service.enrollStudent(subjectId, studentId);
    }

    @PutMapping("/assign")
    public String assignSubjectToTeacher(@RequestParam(name = "subject-id") Long subjectId,
                                         @RequestParam(name = "teacher-id") Long teacherId){
        return service.assignSubject(subjectId,teacherId);
    }
}
