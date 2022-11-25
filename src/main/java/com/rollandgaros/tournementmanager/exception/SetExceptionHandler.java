package com.rollandgaros.tournementmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SetExceptionHandler {

    /*@ExceptionHandler(value = BadRequestSetException.class)
    public ResponseEntity<Object> handlesetBadRequestExecption
            (BadRequestSetException badRequestSetException)
    {
        SetException setException = new SetException(
                badRequestSetException.getMessage(),
                badRequestSetException.getCause(),
                HttpStatus.BAD_REQUEST
        );

        return new ResponseEntity<>(setException,HttpStatus.BAD_REQUEST);
    }*/

    @ExceptionHandler(value = {BadRequestSetException.class, SetNotFoundException.class})
    public ResponseEntity<Object> handlesetNotFoundExecption
            (SetNotFoundException setNotFoundException)
    {
        SetException setException = new SetException(
                setNotFoundException.getMessage(),
                setNotFoundException.getCause(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(setException,HttpStatus.NOT_FOUND);
    }
}
