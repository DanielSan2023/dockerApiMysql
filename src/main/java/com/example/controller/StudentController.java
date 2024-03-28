package com.example.controller;

import com.example.entity.Student;
import com.example.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Student>> findAllStudents() {
        List<Student> students = studentService.getAllStudent();
        if (students == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(studentService.getAllStudent(), HttpStatus.OK);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student newStudent = studentService.createNewStudent(student);
        return new ResponseEntity<>(newStudent, HttpStatus.CREATED);
    }

}
