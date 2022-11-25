package com.rollandgaros.tournementmanager.exception;

import org.springframework.http.HttpStatus;

public class BadRequestSetException extends RuntimeException{
    public BadRequestSetException(String message) {
        super(message);
    }


    public BadRequestSetException(String message, Throwable cause) {
        super(message, cause);
    }
}
