package com.example.library_api.exception;

public class LoanAlreadyReturnedException extends RuntimeException {

    public LoanAlreadyReturnedException() {
        super("Loan is already returned");
    }
}