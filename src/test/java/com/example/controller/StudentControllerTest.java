package com.example.controller;


import com.example.entity.Student;
import com.example.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    void GIVEN_mocked_student_as_null_WHEN_create_Student_THEN_return_null() {
        //GIVEN
        when(studentService.createNewStudent(any())).thenReturn(null);

        //WHEN
        ResponseEntity<Student> returnValue = studentController.createStudent(new Student());

        //THEN
        assertThat(returnValue.getBody()).isNull();
    }

    @Test
    void GIVEN_mocked_student_WHEN_create_Student_THEN_return_created_Student() {
        //GIVEN
        when(studentService.createNewStudent(any())).thenReturn(new Student());

        //WHEN
        ResponseEntity<Student> returnValue = studentController.createStudent(new Student());

        //THEN
        assertThat(returnValue.getBody()).isNotNull();
        assertThat(returnValue.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void GIVEN_mocked_students_as_null_WHEN_findAllStudents_THEN_return_NOT_FOUND() {
        //GIVEN
        List<Student> students = null;
        when(studentService.getAllStudent()).thenReturn(students);

        //WHEN
        ResponseEntity<List<Student>> returnValue = studentController.findAllStudents();

        //THEN
        assertThat(returnValue.getBody()).isNull();
        assertThat(returnValue.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
    }

    @Test
    void GIVEN_mocked_List_students_WHEN_findAllStudents_THEN_return_List_student_HttpStatus_OK() {
        //GIVEN
        List<Student> students = new ArrayList<>();

        students.add(new Student());
        students.add(new Student());
        students.add(new Student());

        when(studentService.getAllStudent()).thenReturn(students);

        //WHEN
        ResponseEntity<List<Student>> returnValue = studentController.findAllStudents();

        //THEN
        assertThat(returnValue.getBody()).isNotNull().hasSize(4);
        assertThat(returnValue.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

}