package io.parth.producerservic.bookservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.parth.producerservic.bookservice.domain.Book;
import io.parth.producerservic.bookservice.repository.BookRepo;
@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepo bookRepo;

	@Override
	public Book createBook(Book book) {
		return bookRepo.save(book);
	}

	@Override
	public Book updateBook(String isbn, Book book) {
		Optional<Book> retrivedBook = bookRepo.findById(isbn);
		if(retrivedBook.isPresent()) {
			Book updatedBook = retrivedBook.get();
			updatedBook.setAuthor(book.getAuthor());
			updatedBook.setTitle(book.getTitle());
			return bookRepo.save(updatedBook);
		}
		return null;
	}

	@Override
	public Optional<Book> findByIsbn(String isbn) {
		return bookRepo.findById(isbn);
	}

	@Override
	public List<Book> findByAuthor(String auther) {
		return bookRepo.findAllByAuthor(auther).stream().collect(Collectors.toList());
	}

	@Override
	public List<Book> findByTitleLike(String title) {
		return bookRepo.findAllByTitleLike(title);
	}

	@Override
	public List<Book> findAll() {
		return bookRepo.findAll().stream().collect(Collectors.toList());
	}

	@Override
	public void deleteBook(Book book) {
		bookRepo.delete(book);
	}

}
