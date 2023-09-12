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
    private BookStatus bookStatus = BookStatus.AVAILABLE;
    private Long customer_id;
    private LocalDate return_date;
}
