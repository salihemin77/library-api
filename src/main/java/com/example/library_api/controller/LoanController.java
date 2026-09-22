package com.example.library_api.controller;

import com.example.library_api.entity.Loan;
import com.example.library_api.service.LoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LoanController {
    private LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }
     @GetMapping("/loans")
    public List<Loan> getLoans() {
        return loanService.findAll();
     }
     @GetMapping("/loans/{id}")
    public Loan getLoanById(@PathVariable Integer id) {
        return loanService.findById(id);
     }
     @PostMapping("/loans/borrow")
     public Loan borrowLoan(@RequestParam Integer userId, @RequestParam Integer bookId) {
        return loanService.borrowBook(userId, bookId);

     }

     @PutMapping("/loans/return/{loanId}")
     public Loan returnLoan(@PathVariable Integer loanId) {
        return loanService.returnBook(loanId);
     }


 @DeleteMapping("/loans/{id}")
    public void deleteLoan(@PathVariable Integer id) {
        loanService.deleteById(id);
 }


}
