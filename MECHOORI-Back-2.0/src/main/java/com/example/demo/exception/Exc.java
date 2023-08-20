package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Exc {
    public static ResponseEntity<Object> handleException(Object obj){
        if(obj == null)
            return new ResponseEntity<Object>("없네요", HttpStatus.NOT_FOUND);

        return new ResponseEntity<Object>(obj, HttpStatus.OK);
    }
}
