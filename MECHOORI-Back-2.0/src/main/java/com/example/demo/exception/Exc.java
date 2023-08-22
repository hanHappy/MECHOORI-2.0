package com.example.demo.exception;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Exc {
    public static <T> ResponseEntity<T> handleException(T obj){
        if(obj == null)
            return new ResponseEntity<T>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<T>(obj, HttpStatus.OK);
    }

    public static <T> ResponseEntity<List<T>> handleException(List<T> list){
        if(list.isEmpty()){
            return new ResponseEntity<List<T>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<T>>(list, HttpStatus.OK);
    }
}
