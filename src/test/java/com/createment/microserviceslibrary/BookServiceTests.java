package com.createment.microserviceslibrary;

import com.createment.microserviceslibrary.book.BookRepository;
import com.createment.microserviceslibrary.book.BookService;
import com.createment.microserviceslibrary.book.Customer;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(properties = "spring.config.location=classpath:/application.properties")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BookServiceTest {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookService bookService;
    Customer existingCustomer = new Customer();
    Customer newCustomer = new Customer();


    @BeforeAll
    void init() {
        existingCustomer.setName("Bob");
        newCustomer.setName("Rob");
    }

    @Test
    void shouldLendBookToExistingCustomer() {
        bookService.lendBook(1L, existingCustomer);
        assertFalse(bookService.isBookAvailable(1L));
    }

    @Test
    void shouldLendBookToNewCustomer() {

    }

    @Test
    void shouldCheckIfBookIsAvaiable() {
        assertTrue(bookService.isBookAvailable(1L));
    }
}
