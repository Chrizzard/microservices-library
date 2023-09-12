package com.createment.microserviceslibrary.book;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.awt.print.Book;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public void lendBook(Book book, Customer customer) {

    }

    /*
    It should also have an end point to lend a book that accepts the book and customer data.
    The lending customer can be an existing customer or a new customer. In case of a new customer their details should be passed to Customer microservice.
     */
}
