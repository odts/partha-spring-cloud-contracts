package io.parth.producerservic.bookservice.service;

import java.util.List;
import java.util.Optional;

import io.parth.producerservic.bookservice.domain.Book;

public interface BookService {
	
	public Book createBook(Book book);
	public Book updateBook(String isbn, Book book);
	public Optional<Book> findByIsbn(String isbn);
	public List<Book> findByAuthor(String auther);
	public List<Book> findByTitleLike(String title);
	public List<Book> findAll();
	public void deleteBook(Book book);

}
