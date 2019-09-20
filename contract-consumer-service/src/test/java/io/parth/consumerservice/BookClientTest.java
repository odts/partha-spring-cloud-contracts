package io.parth.consumerservice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties.StubsMode;
import org.springframework.test.context.junit4.SpringRunner;

import io.parth.consumerservice.domain.Book;
import io.parth.consumerservice.feign.BookClient;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureStubRunner(ids = "io.parth:contract-producer-service:+:stubs:9090",
		stubsMode = StubsMode.LOCAL)
public class BookClientTest {
	
	@Autowired
	BookClient bookClient;
	
	@Test
	public void getBooksByISBNCompliesToContract() {
		Book book = bookClient.getBookByIsbn("123").get();
		assertEquals("123", book.getIsbn());
		assertEquals(2, bookClient.getAllBooks().size());
		
	}

}
