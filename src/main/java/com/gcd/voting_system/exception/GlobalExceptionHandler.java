package com.gcd.voting_system.exception;

import com.gcd.voting_system.exception.customExceptions.ExpiredVoteException;
import com.gcd.voting_system.exception.customExceptions.NotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ExpiredVoteException.class)
    public ResponseEntity<ErrorResponse> handleExpiredVoteException(ExpiredVoteException ex) {
        ErrorResponse errorResponse = new ErrorResponse(403, ex.getMessage());

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorResponse);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex) {
        ErrorResponse errorResponse = new ErrorResponse(404, ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
