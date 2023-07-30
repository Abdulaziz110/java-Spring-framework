package com.courses.restapi.errors;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class CourseExptionHndlers extends ResponseEntityExceptionHandler {


    @ExceptionHandler(CourseNotFoundExption.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public final ResponseEntity<ErrorMessage> responseEntity(final CourseNotFoundExption ex){

        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(),"404");
        return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);

 }








}


