package com.example.library_api.service;

import com.example.library_api.entity.Book;
import com.example.library_api.entity.Loan;
import com.example.library_api.entity.User;
import com.example.library_api.enums.BookStatus;
import com.example.library_api.enums.LoanStatus;
import com.example.library_api.exception.*;
import com.example.library_api.repository.BookRepository;
import com.example.library_api.repository.LoanRepository;
import com.example.library_api.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class LoanServiceImpl implements LoanService {
    private LoanRepository loanRepository;
    private BookRepository bookRepository;
    private UserRepository userRepository;

    public LoanServiceImpl(LoanRepository loanRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.loanRepository = loanRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public Loan save(Loan loan) {
        return loanRepository.save(loan);
    }

    @Override
    public List<Loan> findAll() {
        return loanRepository.findAll();
    }

    @Override
    public Loan findById(Integer id) {
        return loanRepository.findById(id).orElseThrow(()->new LoanNotFoundException());
    }

    @Override
    public void deleteById(Integer id) {
        loanRepository.deleteById(id);

    }
@Transactional
    @Override
    public Loan borrowBook(Integer userId, Integer bookId) {
        User user = userRepository.findById(userId).orElseThrow(()->new UserNotFoundException());
        Book book = bookRepository.findById(bookId).orElseThrow(()->new BookNotFoundException());

        if (book.getStatus() != BookStatus.AVAILABLE) {
             throw new BookAlreadyBorrowedException();
        }
        Loan loan = new Loan();
        loan.setUser(user);
        loan.setBook(book);
        loan.setLoanDate(LocalDateTime.now());
        loan.setStatus(LoanStatus.BORROWED);
        book.setStatus(BookStatus.BORROWED);

        return loanRepository.save(loan);




    }

@Transactional
    @Override
    public Loan returnBook(Integer loanId) {

        Loan loan = loanRepository.findById(loanId).orElseThrow(()->new LoanNotFoundException());
        if (loan.getStatus() == LoanStatus.RETURNED) {
           throw new LoanAlreadyReturnedException();
        }
        loan.setReturnDate(LocalDateTime.now());
        loan.setStatus(LoanStatus.RETURNED);
        loan.getBook().setStatus(BookStatus.AVAILABLE);



        return loanRepository.save(loan);
    }
}
