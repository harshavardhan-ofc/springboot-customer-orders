package com.project.customer.orders.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> handleResourceNotFound(ResourceNotFoundException ex){
        Map<String,Object> errorBody =new HashMap<>();
        errorBody.put("timestamp", LocalDateTime.now());
        errorBody.put("message",ex.getMessage());
        errorBody.put("status", HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(errorBody,HttpStatus.NOT_FOUND);

    }

    public ResponseEntity<Object> handleAllExceptions(Exception ex){
        Map<String,Object> errorBody=new HashMap<>();
        errorBody.put("timestamp",LocalDateTime.now());
        errorBody.put("message",ex.getMessage());
        errorBody.put("status",HttpStatus.INTERNAL_SERVER_ERROR);

        return  new ResponseEntity<>(errorBody,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
