package com.example.library_api.mapper;

import com.example.library_api.dto.BookResponseDTO;
import com.example.library_api.entity.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {
    public BookResponseDTO toDTO(Book book) {
        return new BookResponseDTO(
                book.getId(),
                book.getTitle(),
                book.getAuthor(),
                book.getIsbn(),
                book.getStatus()
        );





    }
}
