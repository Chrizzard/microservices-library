package com.createment.microserviceslibrary.book;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookservice;
    private final BookRepository bookrepository;

    @Autowired
    public BookController(BookService bookservice, BookRepository bookrepository) {
        this.bookservice = bookservice;
        this.bookrepository = bookrepository;
    }

    @GetMapping
    public List<Book> displayAllBooks() {
        return bookrepository.findAll();
    }

    @GetMapping("/{bookId}")
    public Book displayBookById(@PathVariable Long bookId) {
        return bookrepository.findById(bookId);
    }

    @GetMapping("/lending/{bookId}")
    public void lendBookById(@PathVariable Long bookId) {

    }

    /*
    ✅ Book microservice should contain an end point for all books, it should also expose if the book is currently lended or not.
    It should also have an end point to lend a book that accepts the book and customer data.
    The lending customer can be an existing customer or a new customer. In case of a new customer their details should be passed to Customer microservice.
     */

}
