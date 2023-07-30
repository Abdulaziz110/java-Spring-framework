package com.courses.restapi.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class StudentExceptionHandlers {


        @ExceptionHandler(StudentNotFoundException.class)
        @ResponseStatus(HttpStatus.NOT_FOUND)
        @ResponseBody
        public final ResponseEntity<ErrorMessage> responseEntity(final StudentNotFoundException ex) {

            ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), "404");
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);

        }
}
