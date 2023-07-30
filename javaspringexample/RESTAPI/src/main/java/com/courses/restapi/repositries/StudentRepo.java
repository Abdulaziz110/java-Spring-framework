package com.courses.restapi.repositries;

import com.courses.restapi.entities.Students.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {

}
