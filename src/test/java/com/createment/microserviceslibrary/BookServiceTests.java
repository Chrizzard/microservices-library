package com.createment.microserviceslibrary;

import com.createment.microserviceslibrary.book.*;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;

import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@SpringBootTest(properties = "spring.config.location=classpath:/application.properties")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BookServiceTest {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    BookService bookService = mock(BookService.class);
    @Autowired
    WebClientConfiguration webClientConfiguration;
    public static MockWebServer mockBackEnd;
    Customer existingCustomer = new Customer();

    @BeforeAll
    static void setUp() throws IOException {
        mockBackEnd = new MockWebServer();
        mockBackEnd.start();
    }

    @BeforeEach
    void initialize() {
        String baseurl = String.format("http://localhost:%s",
                mockBackEnd.getPort());
    }

    @Test
    void shouldLendBookToExistingCustomer() throws Exception {
//        bookService.lendBook(1L, existingCustomer);
//        mockBackEnd.enqueue(new MockResponse()
//                .setBody());


//        Mono<Book> bookMono = bookRepository.findById(1L);
//
//        StepVerifier.create(bookMono)
//                .expectNextMatches(book -> book.getBookStatus()
//                        .equals(false))
//                .verifyComplete();
    }

    @Test
    void shouldLendBookToNewCustomer() {

    }

    @Test
    void shouldCheckIfBookIsAvaiable() {
        assertTrue(bookService.isBookAvailable(1L));
    }

    @AfterAll
    static void tearDown() throws IOException {
        mockBackEnd.shutdown();
    }
}
