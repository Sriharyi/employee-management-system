package com.sriharyi.ems.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // This annotation is used to handle exceptions globally
public class RestExceptionHandler {
    @ExceptionHandler(value = EmailAlreadyExistsException.class)
    public ResponseEntity<?> handleEmailAlreadyExistsException() {
        return new ResponseEntity<>("Email already exists", HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(value = DepartmentNotFoundException.class)
    public ResponseEntity<?> handleDepartmentNotFoundException() {
        return new ResponseEntity<>("Department not found", HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(value = EmployeeNotFoundException.class)
    public ResponseEntity<?> handleEmployeeNotFoundException() {
        return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(value = PositionNotFoundException.class)
    public ResponseEntity<?> handlePositionNotFoundException() {
        return new ResponseEntity<>("Position not found", HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(value = SalaryNotFoundException.class)
    public ResponseEntity<?> handleSalaryNotFoundException() {
        return new ResponseEntity<>("Salary not found", HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(value = ManagerHistoryNotFoundException.class)
    public ResponseEntity<?> handleManagerHistoryNotFoundException() {
        return new ResponseEntity<>("Manager history not found", HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(value = ManagerExeedEmployeeAdditionLimitException.class)
    public ResponseEntity<?> handleManagerExeedEmployeeAdditionLimitException() {
        return new ResponseEntity<>("Manager exceeded employee addition limit", HttpStatus.BAD_REQUEST);
    }
}
