package com.createment.microserviceslibrary;

import com.createment.microserviceslibrary.book.Book;
import com.createment.microserviceslibrary.book.BookService;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jayway.jsonpath.JsonPath;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
public class ControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BookService bookService;

    @Test
    void testDisplayAllBooks() throws Exception {
        mockMvc.perform(get("/books"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[6]").exists())
                .andExpect(jsonPath("$[6].title").value("Van Peuter tot Kleuter"))
                .andExpect(jsonPath("$[7]").doesNotExist());
    }

    @Test
    void testFindBookById() throws Exception {
        mockMvc.perform(get("/books/3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.title").value("Harry Potter 3"));
    }

    @Test
    void testAddBook() throws Exception {
        mockMvc.perform(post("/books"))
                .andExpect(status().isCreated());
    }
}
