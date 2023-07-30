package com.courses.restapi.errors;

public class CourseNotFoundExption extends RuntimeException {


    public CourseNotFoundExption(String message) {

    super(message);

    }
}
