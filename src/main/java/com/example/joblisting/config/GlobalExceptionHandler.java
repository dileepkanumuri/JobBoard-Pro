// Global exception handler to format validation errors

package com.example.joblisting.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<?> handleValidation(MethodArgumentNotValidException ex) {
    List<Map<String, String>> details = ex.getBindingResult()
        .getFieldErrors()
        .stream()
        .map(err -> Map.of(
            "field", err.getField(),
            "message", err.getDefaultMessage()))
        .collect(Collectors.toList());

    Map<String, Object> body = Map.of(
        "timestamp", Instant.now().toString(),
        "status", 400,
        "error", "VALIDATION_FAILED",
        "details", details
    );
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
  }
}
