package com.example.library_api.repository;

import com.example.library_api.entity.Loan;
import com.example.library_api.enums.LoanStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan,Integer> {
    long countByUserIdAndStatus(int userId, LoanStatus status);



}
