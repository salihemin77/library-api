package com.example.library_api.exception;

public class MaximumLoanLimitException extends RuntimeException {
    public MaximumLoanLimitException() {
        super("User cannot borrow more than 3 books");
    }

}
