package com.courses.restapi.repositries;

import com.courses.restapi.entities.courses.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface CourseRepo extends JpaRepository<Course,Long> {
}
