package io.parth.producerservic.bookservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.parth.producerservic.bookservice.domain.Book;

public interface BookRepo extends JpaRepository<Book, String>{
	
	public List<Book> findAll();
	public List<Book> findAllByAuthor(String auther);
	public List<Book> findAllByTitleLike(String title);

}
