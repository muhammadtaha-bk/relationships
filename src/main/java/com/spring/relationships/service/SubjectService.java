package com.spring.relationships.service;

import com.spring.relationships.model.Subject;
import org.springframework.http.ResponseEntity;

public interface SubjectService {
    ResponseEntity getAll();

    String createSubject(Subject subject);

    String enrollStudent(Long subjectId, Long studentId);

    String assignSubject(Long subjectId, Long teacherId);
}
