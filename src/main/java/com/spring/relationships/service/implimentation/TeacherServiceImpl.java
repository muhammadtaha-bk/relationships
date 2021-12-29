package com.spring.relationships.service.implimentation;

import com.spring.relationships.model.Teacher;
import com.spring.relationships.repository.TeacherRepository;
import com.spring.relationships.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements TeacherService {
    private final TeacherRepository repository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @Override
    public String createTeacher(Teacher teacher) {
        repository.save(teacher);
        return "Teacher added \u2713";
    }
}
