package com.courses.restapi.srevices.StudentServices;

import com.courses.restapi.entities.Students.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentService {


    ResponseEntity<List<Student>> findAll();

    ResponseEntity<Student> findById(Long id);

    ResponseEntity<Student> creat(Student addStudent);

    ResponseEntity<Student> update(Long id , Student NewStudent);

    ResponseEntity<String> remove(Long id);



}