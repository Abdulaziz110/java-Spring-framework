package com.courses.restapi.entities.mapper;

import com.courses.restapi.entities.courses.Course;
import com.courses.restapi.entities.courses.dto.AddCourseDto;
import com.courses.restapi.entities.courses.dto.CourseDto;

public class CourseMapperImpl implements CourseMapper {
    @Override
    public Course addCourseDtoToCource(AddCourseDto addCourseDto) {

        Course course = new Course();
        course.setTitle(addCourseDto.getTitle());
        course.setDescription(addCourseDto.getDescription());
        course.setPrice(addCourseDto.getPrice());

        return course;

    }

    @Override
    public CourseDto CourseoToCourceDto(Course course) {

        return new CourseDto(course);
    }
}
