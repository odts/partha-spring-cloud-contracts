package io.parth.producerservic;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.test.web.servlet.setup.StandaloneMockMvcBuilder;

import io.parth.producerservic.bookservice.controller.BooksController;
import io.parth.producerservic.bookservice.domain.Book;
import io.parth.producerservic.bookservice.repository.BookRepo;
import io.restassured.module.mockmvc.RestAssuredMockMvc;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class BookApiBase {

	
    @Autowired
    BooksController bookController;

    @MockBean
    private BookRepo repository;

    @Before
    public void setup() {
        //Book book= new Book("123", "Ferok Book", "Fero Hero");
        Book book= new Book("123", "some Author", "some Book");
        Book book2= new Book("123", "some Author", "some Book");
        List<Book> bookList = new ArrayList<>();
        bookList.add(book);
        bookList.add(book2);
        
        when(repository.findById(any(String.class))).thenReturn(Optional.of(book));
        when(repository.save(any(Book.class))).thenReturn(book);
        when(repository.findAll()).thenReturn(bookList);

		
		  StandaloneMockMvcBuilder standaloneMockMvcBuilder =
		  MockMvcBuilders.standaloneSetup(bookController);
		  RestAssuredMockMvc.standaloneSetup(standaloneMockMvcBuilder);
		 
        
    }

}