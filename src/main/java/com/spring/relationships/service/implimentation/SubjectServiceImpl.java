package com.spring.relationships.service.implimentation;

import com.spring.relationships.controller.TeacherController;
import com.spring.relationships.model.Student;
import com.spring.relationships.model.Subject;
import com.spring.relationships.model.Teacher;
import com.spring.relationships.repository.StudentRepository;
import com.spring.relationships.repository.SubjectRepository;
import com.spring.relationships.repository.TeacherRepository;
import com.spring.relationships.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl implements SubjectService {
    private final SubjectRepository repository;
    private final StudentRepository studentRepo;
    private final TeacherRepository teacherRepo;

    @Autowired
    public SubjectServiceImpl(SubjectRepository repository,
                              StudentRepository studentRepo,
                              TeacherRepository teacherRepo) {
        this.repository = repository;
        this.studentRepo = studentRepo;
        this.teacherRepo = teacherRepo;
    }

    @Override
    public ResponseEntity getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }

    @Override
    public String createSubject(Subject subject) {
        repository.save(subject);
        return "Subject added \u2713";
    }

    @Override
    public String enrollStudent(Long subjectId, Long studentId) {
        Subject subject = repository.findById(subjectId).get();
        Student student = studentRepo.findById(studentId).get();

        subject.enrollStudent(student);
        repository.save(subject);
        return "Student enrolled \u2713";
    }

    @Override
    public String assignSubject(Long subjectId, Long teacherId) {
        Subject subject = repository.findById(subjectId).get();
        Teacher teacher = teacherRepo.findById(teacherId).get();

        subject.setTeacherAssigned(teacher);
        repository.save(subject);
        return "Teacher assigned \u2713";
    }
}
