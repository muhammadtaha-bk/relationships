package com.spring.relationships.service;

import com.spring.relationships.model.Teacher;
import org.springframework.http.ResponseEntity;

public interface TeacherService {
    ResponseEntity getAll();

    String createTeacher(Teacher teacher);
}
