package com.example.library_api.entity;

import com.example.library_api.enums.BookStatus;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @Column(name = "title")
    private String title;
    @NotBlank
    @Column(name = "author")
    private String author;
    @NotBlank
    @Column(name = "isbn")
    private String isbn;
    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private BookStatus status;



    public Book() {
    }

    public Book(String author, String isbn, BookStatus status, String title) {
        this.author = author;

        this.isbn = isbn;
        this.status = status;
        this.title = title;

    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }



    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", status=" + status +

                '}';
    }
}
