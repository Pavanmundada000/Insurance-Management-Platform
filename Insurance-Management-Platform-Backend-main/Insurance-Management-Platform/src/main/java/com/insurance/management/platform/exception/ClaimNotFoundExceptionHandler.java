package com.insurance.management.platform.exception;

public class ClaimNotFoundExceptionHandler extends RuntimeException{
    public ClaimNotFoundExceptionHandler(String message) {
        super(message);
    }
}
