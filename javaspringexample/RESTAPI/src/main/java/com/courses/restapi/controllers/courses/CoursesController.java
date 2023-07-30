package com.courses.restapi.controllers.courses;

import com.courses.restapi.entities.courses.dto.AddCourseDto;
import com.courses.restapi.entities.courses.dto.CourseDto;
import com.courses.restapi.srevices.courseServices.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/courses")
public class CoursesController {

    private final CourseService courseService;


    @Autowired
    public CoursesController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("")
    public ResponseEntity<List<CourseDto>> getCourses(){
        return this.courseService.findAll();
}


    @GetMapping("/{courseID}")
    public ResponseEntity<CourseDto> getCourse(@PathVariable Long courseID){

        return this.courseService.findById(courseID);
    }

    @PostMapping("")
    public  ResponseEntity<CourseDto> creatCourse(@RequestBody @Valid AddCourseDto addCourseDto){

       return this.courseService.creat(addCourseDto);
    }

    @PutMapping("/{courseID}")
    public ResponseEntity<CourseDto> update(@PathVariable Long courseID, @RequestBody @Valid AddCourseDto addCourseDto){

        return this.courseService.update(courseID,addCourseDto);
    }

    @DeleteMapping("/{courseID}")
    public ResponseEntity<String> delete(@PathVariable Long courseID){

        return this.courseService.remove(courseID);
    }

}
