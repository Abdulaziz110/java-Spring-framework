package com.courses.restapi.entities.courses.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;


@Setter
@Getter
@AllArgsConstructor
@ToString

public class AddCourseDto {
    private String title;
    private String description;
    private BigDecimal price;





}
