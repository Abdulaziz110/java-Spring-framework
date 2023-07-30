package com.courses.restapi.srevices.courseServices;

import com.courses.restapi.entities.courses.dto.AddCourseDto;
import com.courses.restapi.entities.courses.dto.CourseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CourseService {

   ResponseEntity<List<CourseDto>> findAll();

   ResponseEntity<CourseDto> findById(Long id);

   ResponseEntity<CourseDto> creat(AddCourseDto addCourseDto);

   ResponseEntity<CourseDto> update(Long id , AddCourseDto NewCourse);

   ResponseEntity<String> remove(Long id);





}
