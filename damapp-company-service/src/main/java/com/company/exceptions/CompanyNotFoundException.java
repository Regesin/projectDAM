package com.company.exceptions;

public class CompanyNotFoundException extends RuntimeException{
    public CompanyNotFoundException() {
    }

    public CompanyNotFoundException(String message) {
        super(message);
    }
}
