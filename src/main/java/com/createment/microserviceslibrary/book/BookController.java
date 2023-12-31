package com.createment.microserviceslibrary.book;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping()
    public Book addBook(@RequestBody Book book) {
        return bookrepository.save(book);
    }

    @PutMapping("/lending/{bookId}/")
    public void lendBookById(@PathVariable Long bookId, @RequestBody Customer customer) {
        bookservice.lendBook(bookId, customer);
    }
}
