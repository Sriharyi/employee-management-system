package com.sriharyi.ems.exception;

public class ManagerExeedEmployeeAdditionLimitException extends RuntimeException {
    public ManagerExeedEmployeeAdditionLimitException(String message) {
        super(message);
    }
}
