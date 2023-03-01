package com.example.registrationlogindemo.config.exceptionHandler;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.registrationlogindemo.exceptions.user.EmailNotFoundException;

@ControllerAdvice
public class UserExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmailNotFoundException.class)
    public Map<String, String> handleEmailNotFoundException(EmailNotFoundException ex) {
        return ErrorResponse.getErrorResponse(ex.getMessage());
    }
}
