package com.anon007.quillcraftapi.exceptions;

import com.anon007.quillcraftapi.payloads.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public APIResponse resourceNotFoundExceptionHandler(ResourceNotFoundException resourceNotFoundException) {
        String message = resourceNotFoundException.getMessage();
        return new APIResponse(message, false, HttpStatus.INTERNAL_SERVER_ERROR.value());
    }
}
