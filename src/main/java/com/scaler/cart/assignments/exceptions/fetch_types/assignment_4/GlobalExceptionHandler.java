package com.scaler.cart.assignments.exceptions.fetch_types.assignment_4;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ShortInventoryException.class)
    public ResponseEntity<String> handleShortInventoryException() {
        return ResponseEntity.internalServerError().body("Ordered Quantity is not Available");
    }

}
