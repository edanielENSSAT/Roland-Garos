package com.rollandgaros.tournementmanager.exception;

public class SetNotFoundException extends RuntimeException{
    public SetNotFoundException(String message) {
        super(message);
    }


    public SetNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
