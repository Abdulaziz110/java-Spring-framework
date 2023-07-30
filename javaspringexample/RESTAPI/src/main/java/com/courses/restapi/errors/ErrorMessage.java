package com.courses.restapi.errors;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ErrorMessage {


    private String message;
    private String code;

}
