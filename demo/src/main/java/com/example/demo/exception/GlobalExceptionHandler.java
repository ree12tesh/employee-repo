package com.example.demo.exception;

import com.example.demo.response.ApiError;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<?> handleEmployeeNotFoundException(HttpServletRequest request, EmployeeNotFoundException e){
        log.info("Employee is not present in System database for api '{}' ", request.getRequestURI());
        ApiError apiError = ApiError.builder()
                .setHttpStatus(HttpStatus.BAD_REQUEST)
                .setMessage(e.getMessage())
                //.setApiName(request.getRequestURI())
                .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
    }
}
