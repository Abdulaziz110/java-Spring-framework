package com.courses.restapi.entities.courses;

import com.courses.restapi.entities.BaseEntity;
import com.courses.restapi.entities.Students.Student;
import jakarta.persistence.*;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "courses")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Course extends BaseEntity {

    @NotNull
    @NotBlank(message = "Title may not be blank")
    @Column(name = "title", length = 100)
    @Size(max = 100, message = "Title may not be longer than 100 characters")
    private String title;

    @NotNull
    @NotBlank(message = "Description may not be blank")
    @Column(name = "description", length = 1000)
    @Size(max = 1000, message = "Description may not be longer than 1000 characters")
    private String description;

    @NotNull(message = "Price may not be null")
    @DecimalMin("1.00")
    private BigDecimal price;


}
