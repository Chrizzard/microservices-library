package com.createment.microserviceslibrary.book;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private BookStatus bookStatus;
    private String customer_id;
    private LocalDate return_date;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.bookStatus = BookStatus.AVAILABLE;
    }
}
