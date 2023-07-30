package com.courses.restapi.entities.Students;

import com.courses.restapi.entities.BaseEntity;
import com.courses.restapi.entities.courses.Course;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student extends BaseEntity {

    @NotNull
    @NotBlank(message = "First name may not be blank")
    @Size(max = 20, message = "First name may not be longer than 20 letters")
    private String FN;

    @NotNull
    @NotBlank(message = "Last name may not be blank")
    @Size(max = 20, message = "Last name may not be longer than 20 letters")
    private String LN;

    @NotNull
    @NotBlank(message = "Phone number may not be blank")
    @Size( max = 20, message = "Phone number must be between 9 and 10 digits")
    private String PhoneNumber;

    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private Set<Course> Enrollments = new HashSet<>();
}
