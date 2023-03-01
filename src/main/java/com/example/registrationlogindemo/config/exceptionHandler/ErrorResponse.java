package com.example.registrationlogindemo.config.exceptionHandler;

import java.util.HashMap;
import java.util.Map;

public final class ErrorResponse {

    private ErrorResponse() {
    }

    static Map<String, String> getErrorResponse(String message) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", message);
        return errorResponse;
    }
}
