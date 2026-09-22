package com.example.library_api.mapper;

import com.example.library_api.dto.LoanResponseDTO;
import com.example.library_api.entity.Loan;
import org.springframework.stereotype.Component;

@Component
public class LoanMapper {

    public LoanResponseDTO toDTO(Loan loan) {

        String username = loan.getUser().getFirstName()
                + " "
                + loan.getUser().getLastName();

        String bookTitle = loan.getBook().getTitle();

        return new LoanResponseDTO(
                loan.getId(),
                username,
                bookTitle,
                loan.getLoanDate(),
                loan.getReturnDate(),
                loan.getStatus()
        );
    }
}