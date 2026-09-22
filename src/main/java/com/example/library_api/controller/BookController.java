package com.example.library_api.controller;

import com.example.library_api.entity.Book;
import com.example.library_api.service.BookService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.findAll();
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable Integer id) {
        return bookService.findById(id);
    }

    @PostMapping("/books")
    public Book createBook( @Valid @RequestBody Book book) {
        return bookService.save(book);
    }



    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Integer id) {
    bookService.deleteById(id);
    }

}
