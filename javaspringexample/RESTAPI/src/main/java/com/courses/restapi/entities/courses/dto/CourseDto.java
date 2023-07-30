package com.courses.restapi.entities.courses.dto;

import com.courses.restapi.entities.courses.Course;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class CourseDto {


    private final Course course;

    public CourseDto(Course course) {
        this.course = course;
    }



    public String getTitle(){
        return this.course.getTitle();

    }

    public String getDescription (){
        return this.course.getDescription();

    }
    public BigDecimal getPrice (){
        return this.course.getPrice().setScale(2, RoundingMode.HALF_UP);

    }

}
