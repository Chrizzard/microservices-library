package com.createment.microserviceslibrary.book;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
@Transactional
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void lendBook(Long bookId, Customer customer) {
        if (isBookAvailable(bookId)) {
            Customer savedCustomer = findCustomer(customer);
            if (findCustomer(customer) == null) {
                savedCustomer = saveCustomer(customer);
            }
            Book savedBook = updateBookLended(bookId, savedCustomer);
            System.out.println(savedBook);
        }
    }

    public boolean isBookAvailable(Long id) {
        Book book = bookRepository.findById(id);
        return book.getBookStatus() == BookStatus.AVAILABLE;
    }

    public Customer findCustomer(Customer customer) {
        WebClient webClient = WebClient.create("localhost:8081");

        List<Customer> customers = webClient.get()
                .uri("/customers/")
                .retrieve()
                .bodyToFlux(Customer.class)
                .collectList()
                .block();

        return customers.stream()
                .filter((c) -> c.equals(customer))
                .findFirst().orElse(null);
    }

    public Customer saveCustomer(Customer customer) {
        WebClient webClient = WebClient.create("localhost:8081");

        Customer savedCustomer = webClient.post()
                .uri("/customers/")
                .body(customer, Customer.class)
                .retrieve()
                .toEntity(Customer.class)
                .block().getBody();
        return savedCustomer;
    }

    public Book updateBookLended(Long bookId, Customer savedCustomer) {
        Book book = bookRepository.findById(bookId);
        book.setBookStatus(BookStatus.LENDED);
        book.setCustomer_id(savedCustomer.getId());
        book.setReturn_date(LocalDate.now().plus(14, ChronoUnit.DAYS));
        book = bookRepository.save(book);
        return book;
    }


    /*
    It should also have an end point to lend a book that accepts the book and customer data.
    The lending customer can be an existing customer or a new customer. In case of a new customer their details should be passed to Customer microservice.
     */
    }
