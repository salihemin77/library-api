package com.example.library_api.dto;

import com.example.library_api.enums.LoanStatus;

import java.time.LocalDateTime;

public class LoanResponseDTO {

    private Integer id;
    private String username;
    private String bookTitle;
    private LocalDateTime loanDate;
    private LocalDateTime returnDate;
    private LoanStatus status;

    public LoanResponseDTO(
            Integer id,
            String username,
            String bookTitle,
            LocalDateTime loanDate,
            LocalDateTime returnDate,
            LoanStatus status) {

        this.id = id;
        this.username = username;
        this.bookTitle = bookTitle;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public LocalDateTime getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDateTime loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public LoanStatus getStatus() {
        return status;
    }

    public void setStatus(LoanStatus status) {
        this.status = status;
    }
}