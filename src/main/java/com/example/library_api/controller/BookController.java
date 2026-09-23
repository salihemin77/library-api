
        package com.example.library_api.controller;

import com.example.library_api.dto.BookResponseDTO;
import com.example.library_api.entity.Book;
import com.example.library_api.mapper.BookMapper;
import com.example.library_api.service.BookService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    private BookService bookService;
    private BookMapper bookMapper;

    public BookController(BookService bookService, BookMapper bookMapper) {
        this.bookService = bookService;
        this.bookMapper = bookMapper;
    }

    @GetMapping("/books")
    public List<BookResponseDTO> getBooks() {
        return bookService.findAll()
                .stream()
                .map(bookMapper::toDTO)
                .toList();
    }

    @GetMapping("/books/{id}")
    public BookResponseDTO getBook(@PathVariable Integer id) {
        Book book = bookService.findById(id);
        return bookMapper.toDTO(book);
    }

    @PostMapping("/books")
    public Book createBook(@Valid @RequestBody Book book) {
        return bookService.save(book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Integer id) {
        bookService.deleteById(id);
    }
    @GetMapping("/books/search")
    public List<BookResponseDTO> searchByTitle(@RequestParam String title) {
        return bookService.searchByTitle(title).stream().map(bookMapper::toDTO).toList();
    }
}

