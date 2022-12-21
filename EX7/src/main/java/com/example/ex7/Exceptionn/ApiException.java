package com.example.ex7.Exceptionn;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}
