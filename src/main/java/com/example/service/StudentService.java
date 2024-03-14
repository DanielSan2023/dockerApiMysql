package com.example.service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    StudentRepository studentRepository;

    public Student createNewStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
}
