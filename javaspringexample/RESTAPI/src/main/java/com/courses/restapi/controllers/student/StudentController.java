package com.courses.restapi.controllers.student;


import com.courses.restapi.entities.Students.Student;
import com.courses.restapi.srevices.StudentServices.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        return studentService.findAll();
    }

    @PostMapping
    public ResponseEntity<Student>  addStudent(@RequestBody Student newStudent){
        return studentService.creat(newStudent);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Student>  updateStudent(@PathVariable Long id,@RequestBody Student updatedStudent){

        return studentService.update(id,updatedStudent);
    }


    @DeleteMapping("{id}")
    public ResponseEntity<String>  deleteStudent(@PathVariable Long id){
        return studentService.remove(id);
    }


    @GetMapping("{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id){
        return studentService.findById(id);
    }

}
