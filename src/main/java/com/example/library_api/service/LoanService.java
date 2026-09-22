package com.example.library_api.service;

import com.example.library_api.entity.Loan;

import java.util.List;

public interface LoanService {
    Loan save(Loan loan);
    List<Loan> findAll();
    Loan findById(Integer id);
    void deleteById(Integer id);
    Loan borrowBook(Integer userId, Integer bookId);
    Loan returnBook(Integer loanId);

}
