package com.courses.restapi.entities.mapper;

import com.courses.restapi.entities.courses.Course;
import com.courses.restapi.entities.courses.dto.AddCourseDto;
import com.courses.restapi.entities.courses.dto.CourseDto;

public interface CourseMapper {


    Course addCourseDtoToCource(AddCourseDto addCourseDto);

    CourseDto CourseoToCourceDto(Course course);


}
