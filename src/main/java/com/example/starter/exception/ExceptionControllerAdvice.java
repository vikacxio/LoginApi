package com.example.starter.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(value= CustomException.class)
    public final ResponseEntity<String>handleCustomException(CustomException customException){
        return new ResponseEntity<>(customException.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value= AuthenticationFailException.class)
    public final ResponseEntity<String>handleAuthenticationFail(AuthenticationFailException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(value= ConstraintViolationException.class)
    public ResponseEntity<Map<String,String>>constraintviolationexception(ConstraintViolationException ex){

        Map<String,String> resq= new HashMap<String,String>();
        String Status= "Failed";
        resq.put("status",Status);

        ex.getConstraintViolations().forEach((error)->{
            String fieldName= String.valueOf(error.getPropertyPath());
            String message = error.getMessage();

            resq.put(fieldName,message);
        });



//        ex.getBindingResult().getAllErrors().forEach((error)->{
//            String fieldName= ((FieldError)error).getField();
//            String message = error.getDefaultMessage();
//            resq.put(fieldName,message);
//        });
        return new ResponseEntity<Map<String,String>>(resq, HttpStatus.BAD_REQUEST);
    }
}
