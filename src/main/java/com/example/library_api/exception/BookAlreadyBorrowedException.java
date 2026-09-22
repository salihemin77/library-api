package com.example.library_api.exception;

public class BookAlreadyBorrowedException extends RuntimeException {
    public BookAlreadyBorrowedException() {
        super("Book already borrowed");


    }

}
