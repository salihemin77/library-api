package com.example.library_api.repository;

import com.example.library_api.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan,Integer> {



}
