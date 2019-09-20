package io.parth.consumerservice.feign;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.parth.consumerservice.domain.Book;

@FeignClient("bookservice")
public interface BookClient {
	@RequestMapping(
			path = "/api/books" , 
			method = RequestMethod.GET, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	List<Book> getAllBooks();
	
	@RequestMapping(
			path = "/api/books",
			method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE
			)
	Book insertBook(@RequestBody Book book);
	
	
	@RequestMapping(
			method = RequestMethod.GET
			,path = "/api/books/{isbn}"
			, consumes = MediaType.APPLICATION_JSON_VALUE)
	Optional<Book> getBookByIsbn(@PathVariable("isbn") String isbn);
}
