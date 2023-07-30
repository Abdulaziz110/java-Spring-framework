package com.courses.restapi.errors;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(BAD_REQUEST)
    public ResponseEntity<List<ErrorMessage>> handleConstraintViolationException(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        List<ErrorMessage> errorMessages = new ArrayList<>();

        for (ConstraintViolation<?> violation : violations) {
            ErrorMessage errorMessage = new ErrorMessage(violation.getMessage(), "400");
            errorMessages.add(errorMessage);
        }

        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
    }


}

