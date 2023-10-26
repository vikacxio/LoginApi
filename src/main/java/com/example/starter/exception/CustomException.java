package com.example.starter.exception;

public class CustomException extends IllegalArgumentException{
    public CustomException(String msg){
        super(msg);
    }
}
