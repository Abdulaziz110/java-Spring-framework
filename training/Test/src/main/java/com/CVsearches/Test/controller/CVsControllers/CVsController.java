package com.CVsearches.Test.controller.CVsControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CVsController {

    @Autowired
    private getcvController getcvController;
    @GetMapping("CVs?result={word}")
    public ResponseEntity<List<String>> getCVs(@PathVariable String word){
        List<String> pdfs = getcvController.getPdfsContainingWord("C:\\Users\\Abdul\\Desktop\\cvs",word);
        return new ResponseEntity<>(pdfs, HttpStatus.OK);
    }

}
