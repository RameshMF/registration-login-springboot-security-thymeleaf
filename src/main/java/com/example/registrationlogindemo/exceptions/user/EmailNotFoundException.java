package com.example.registrationlogindemo.exceptions.user;

import jakarta.validation.constraints.NotEmpty;

public class EmailNotFoundException extends RuntimeException {
    public EmailNotFoundException(@NotEmpty String errorMessage){
        super(errorMessage);
    }
}
