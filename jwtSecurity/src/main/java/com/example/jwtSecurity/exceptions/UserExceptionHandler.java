package com.example.jwtSecurity.exceptions;

import com.example.jwtSecurity.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(value = {UsernameNotFoundException.class})
    public ResponseEntity<ErrorDto> userNotFound(RuntimeException ex) {
        return new ResponseEntity<>(new ErrorDto(ex.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {UsernameAlreadyExistsException.class})
    public ResponseEntity<ErrorDto> usernameAlreadyExists(RuntimeException ex) {
        return new ResponseEntity<>(new ErrorDto(ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
