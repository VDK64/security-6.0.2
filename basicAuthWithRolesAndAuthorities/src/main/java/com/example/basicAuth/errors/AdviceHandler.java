package com.example.basicAuth.errors;

import com.example.basicAuth.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceHandler {

    @ExceptionHandler(value = {CourseNotFoundException.class})
    protected ResponseEntity<ErrorDto> courseNotFound(RuntimeException ex) {
        ErrorDto errorDto = new ErrorDto(ex.getMessage());
        return new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
    }

}
