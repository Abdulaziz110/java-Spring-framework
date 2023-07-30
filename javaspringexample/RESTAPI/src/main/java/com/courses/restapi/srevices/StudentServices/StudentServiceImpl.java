package com.courses.restapi.srevices.StudentServices;

import com.courses.restapi.entities.Students.Student;
import com.courses.restapi.errors.StudentNotFoundException;
import com.courses.restapi.repositries.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;
    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public ResponseEntity<List<Student>> findAll() {
        List<Student> students = studentRepo.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Student> findById(Long id) {
        Optional<Student> student = studentRepo.findById(id);

        if(student.isEmpty()){
            throw new StudentNotFoundException("Student with id: "+ id+" not found!");
        }
        return new ResponseEntity<>(student.get(),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Student> creat(Student addStudent) {
        Student Newstudent = addStudent;
        studentRepo.save(Newstudent);
        return new ResponseEntity<>(Newstudent,HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Student> update(Long id, Student NewStudent) {
        Optional<Student> student = studentRepo.findById(id);

        if(student.isEmpty()){
            throw new StudentNotFoundException("Student with id: "+ id+" not found!");
        }
        Student student1 = student.get();
        student1.setFN(NewStudent.getFN());
        student1.setLN(NewStudent.getLN());
        student1.setPhoneNumber(NewStudent.getPhoneNumber());
        studentRepo.save(student1);
        return new ResponseEntity<>(student1,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> remove(Long id) {
        Optional<Student> student = studentRepo.findById(id);
        if(student.isEmpty()){
            throw new StudentNotFoundException("Student with id: "+ id+" not found!");
        }
        studentRepo.deleteById(id);
        return new ResponseEntity<>("Student with id:"+id+" has been deleted successfully",HttpStatus.NO_CONTENT);
    }
}
