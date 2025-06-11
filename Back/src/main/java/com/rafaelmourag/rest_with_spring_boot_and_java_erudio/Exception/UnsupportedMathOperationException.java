package com.rafaelmourag.rest_with_spring_boot_and_java_erudio.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException extends RuntimeException{
    public UnsupportedMathOperationException(String message){
        super(message);
    }

}
