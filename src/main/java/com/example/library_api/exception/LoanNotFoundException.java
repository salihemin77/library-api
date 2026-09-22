package com.example.library_api.exception;

public class LoanNotFoundException extends RuntimeException  {
    public LoanNotFoundException() {
        super("Loan not found");
    }
}
