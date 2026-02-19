package com.rizkyjayusman.validation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        StringBuilder sb = new StringBuilder();

        ex.getBindingResult().getGlobalErrors().forEach(error -> {
            if (!sb.isEmpty()) sb.append("; ");
            sb.append(error.getDefaultMessage());
        });

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            if (!sb.isEmpty()) sb.append("; ");
            sb.append(error.getDefaultMessage());
        });

        return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
    }

}