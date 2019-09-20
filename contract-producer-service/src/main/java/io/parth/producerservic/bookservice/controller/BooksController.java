package io.parth.producerservic.bookservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.parth.producerservic.bookservice.domain.Book;
import io.parth.producerservic.bookservice.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BooksController {
	
	@Autowired
	private BookService bookService;
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Book createBook(Book book) {
		return bookService.createBook(book);
	}
	
	
	@RequestMapping(value = "/{isbn}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Book updateBook(@PathVariable String isbn, @RequestBody Book book) {

        return bookService.updateBook(isbn,book);
    }

    @RequestMapping(value = "/{isbn}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Optional<Book> getByIsbn(@PathVariable String isbn) {
        return bookService.findByIsbn(isbn);
    }

    @RequestMapping(
            params = {"author"},
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Book> getByAuthor(@RequestParam(value = "author",required = true) String author){
        return bookService.findByAuthor(author);
    }


    @RequestMapping(
            params = {"title"},
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Book> getByTitle(@RequestParam(value = "title",required = true) String title){
        return bookService.findByTitleLike(title);
    }



    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Book> getAll() {
        return bookService.findAll();
    }

}
