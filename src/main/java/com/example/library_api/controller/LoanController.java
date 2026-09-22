
        package com.example.library_api.controller;

import com.example.library_api.dto.LoanResponseDTO;
import com.example.library_api.entity.Loan;
import com.example.library_api.mapper.LoanMapper;
import com.example.library_api.service.LoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LoanController {

    private LoanService loanService;
    private LoanMapper loanMapper;

    public LoanController(LoanService loanService, LoanMapper loanMapper) {
        this.loanService = loanService;
        this.loanMapper = loanMapper;
    }

    @GetMapping("/loans")
    public List<LoanResponseDTO> getLoans() {
        return loanService.findAll()
                .stream()
                .map(loanMapper::toDTO)
                .toList();
    }

    @GetMapping("/loans/{id}")
    public LoanResponseDTO getLoanById(@PathVariable Integer id) {
        Loan loan = loanService.findById(id);
        return loanMapper.toDTO(loan);
    }

    @PostMapping("/loans/borrow")
    public LoanResponseDTO borrowLoan(
            @RequestParam Integer userId,
            @RequestParam Integer bookId) {

        Loan loan = loanService.borrowBook(userId, bookId);
        return loanMapper.toDTO(loan);
    }

    @PutMapping("/loans/return/{loanId}")
    public LoanResponseDTO returnLoan(@PathVariable Integer loanId) {

        Loan loan = loanService.returnBook(loanId);
        return loanMapper.toDTO(loan);
    }

    @DeleteMapping("/loans/{id}")
    public void deleteLoan(@PathVariable Integer id) {
        loanService.deleteById(id);
    }
}
