package com.courses.restapi.bootstrap;

import com.courses.restapi.entities.Students.Student;
import com.courses.restapi.entities.courses.Course;
import com.courses.restapi.entities.courses.dto.AddCourseDto;
import com.courses.restapi.entities.mapper.CourseMapper;
import com.courses.restapi.entities.mapper.CourseMapperImpl;
import com.courses.restapi.repositries.CourseRepo;
import com.courses.restapi.repositries.StudentRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.math.BigDecimal;
import java.util.stream.IntStream;

@Configuration
public class CourseCommandLineRunner {

    @Bean
    CommandLineRunner initDatabase(CourseRepo courseRepo, StudentRepo  studentRepo){
        return args -> {

            CourseMapper courseMapper = new CourseMapperImpl();
            IntStream.rangeClosed(1,10).forEach(i-> {
                Student student = new Student();
                student.setFN(i+"+ A ");
                student.setLN("B"+i);
                student.setPhoneNumber(i+""+i+i+i+i+i);

                AddCourseDto addCourseDto = new AddCourseDto("course number"+i, "learn course # "+i,new BigDecimal(String.valueOf(i*100)));

                Course course = courseMapper.addCourseDtoToCource(addCourseDto);
                student.getEnrollments().add(course);


                courseRepo.save(course);
                studentRepo.save(student);
            });
        };
    }
}
