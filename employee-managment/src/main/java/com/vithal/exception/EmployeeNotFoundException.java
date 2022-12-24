package com.vithal.exception;

import lombok.Getter;

public class EmployeeNotFoundException extends RuntimeException{

    @Getter
    private String statusCode;


    public EmployeeNotFoundException(String msg, String statusCode) {
        super(msg);
        this.statusCode = statusCode;
    }
}
