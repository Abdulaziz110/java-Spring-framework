package com.courses.restapi.srevices.courseServices;

import com.courses.restapi.entities.courses.Course;
import com.courses.restapi.entities.courses.dto.AddCourseDto;
import com.courses.restapi.entities.courses.dto.CourseDto;
import com.courses.restapi.entities.mapper.CourseMapper;
import com.courses.restapi.entities.mapper.CourseMapperImpl;
import com.courses.restapi.errors.CourseNotFoundExption;
import com.courses.restapi.repositries.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service

public class CourseServiceImpl implements CourseService {


    private final CourseRepo courseRepo;
    private static final CourseMapper mapper = new CourseMapperImpl();
    @Autowired
    public CourseServiceImpl(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }



    @Override
    public ResponseEntity<List<CourseDto>> findAll() {


        List<Course> courses = this.courseRepo.findAll();
        List<CourseDto> courseDtos = courses.stream().map(mapper::CourseoToCourceDto).collect(Collectors.toList());


        return new ResponseEntity<>(courseDtos, HttpStatus.OK);
    }




    @Override
    public ResponseEntity<CourseDto> findById(Long id) {

        Optional<Course> course = this.courseRepo.findById(id);

        if(course.isEmpty()){
            throw  new CourseNotFoundExption("The course with id: "+id+" Not found");
        }

        CourseDto courseDto = mapper.CourseoToCourceDto(course.get());

        return new ResponseEntity<>(courseDto,HttpStatus.OK);

    }

    @Override
    public ResponseEntity<CourseDto> creat(AddCourseDto addCourseDto) {

        final Course course = mapper.addCourseDtoToCource(addCourseDto);
        final Course craetedcourse = this.courseRepo.save(course);
        final CourseDto courseDto = mapper.CourseoToCourceDto(craetedcourse);



        return new ResponseEntity<>(courseDto,HttpStatus.CREATED) ;
    }

    @Override
    public ResponseEntity<CourseDto> update(Long id, AddCourseDto NewCourse) {

        Optional<Course> course = this.courseRepo.findById(id);

        if(course.isEmpty()){
            throw  new CourseNotFoundExption("The course with id: "+id+" Not found");
        }

        Course existingCourse = course.get();
        existingCourse.setTitle(NewCourse.getTitle());
        existingCourse.setDescription(NewCourse.getDescription());
        existingCourse.setPrice(NewCourse.getPrice());
        Course updatedcourse =this.courseRepo.save(existingCourse);
        CourseDto courseDto = mapper.CourseoToCourceDto(updatedcourse);

        return new ResponseEntity<>(courseDto,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> remove(Long id) {

        Optional<Course> course = this.courseRepo.findById(id);
        if(course.isEmpty()){
            throw  new CourseNotFoundExption("The course with id: "+id+" Not found");
        }
        this.courseRepo.deleteById(id);
        return new ResponseEntity<>("Course has been reomved successflly! ",HttpStatus.NO_CONTENT);

    }

}
