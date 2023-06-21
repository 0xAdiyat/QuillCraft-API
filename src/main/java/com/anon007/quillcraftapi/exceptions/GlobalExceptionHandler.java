package com.anon007.quillcraftapi.exceptions;

import com.anon007.quillcraftapi.payloads.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex) {

        Map<String, String> errRes = new HashMap<>();
        /*METHOD ONE
         ex.getBindingResult().getAllErrors().forEach(e -> {
         String fieldName = ((FieldError) e).getField();
         String defaultMessage = e.getDefaultMessage();
         errRes.put(fieldName, defaultMessage);
         });*/
        ex.getBindingResult().getFieldErrors().forEach(e -> errRes.put(e.getField(), e.getDefaultMessage()));

        return new ResponseEntity<>(errRes, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<APIResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex) {
        APIResponse response = new APIResponse();
        response.setMessage(ex.getMessage());
        response.setSuccess(false);
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
