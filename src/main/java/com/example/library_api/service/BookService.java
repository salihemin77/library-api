package com.example.library_api.service;

import com.example.library_api.entity.Book;

import java.util.List;

public interface BookService {
    Book save(Book book);
    Book findById(Integer id);
    List<Book> findAll();
    void deleteById(Integer id);
}
