package com.insurance.management.platform.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class GlobalExceptionHandler {

    @ExceptionHandler(ClientExceptionHandler.class)
    public ProblemDetail onException(ClientExceptionHandler exceptionHandler){
        var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(404), exceptionHandler.getMessage());
        problemDetail.setTitle("Client Not Found");
        problemDetail.setType(URI.create("http://localhost:8080/api/clients/error"));
        return problemDetail;
    }

    @ExceptionHandler(InsurancePolicyExceptionHandler.class)
    public ProblemDetail onException(InsurancePolicyExceptionHandler exception) {
        var problemDetail = ProblemDetail.forStatusAndDetail(HttpStatusCode.valueOf(404), exception.getMessage());
        problemDetail.setTitle("Insurance Policy Not Found!!");
        problemDetail.setType(URI.create("http://localhost:8080/api/policies/error"));
        return problemDetail;
    }

    // claim exceptions handler
    public ProblemDetail onException(ClaimNotFoundExceptionHandler exceptionHandler){
        var problemDetail = ProblemDetail.forStatus(HttpStatus.NOT_FOUND);
       problemDetail.setDetail(exceptionHandler.getMessage());
       problemDetail.setTitle("Claim Not Found");
       problemDetail.setStatus(404);
       problemDetail.setType(URI.create("http://localhost:8080/api/claims/error"));

        return problemDetail;
    }

}
