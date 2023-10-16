package com.example.demo;

import com.example.demo.entity.Book;
import com.example.demo.service.BookImplService;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	BookService bookService;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Book book = new Book();
		book.setTitle("test1");
		book.setAuthor("rana");
		book.setPrice(100.00);
		book.setPages(20);
		book.setDesc("for test");


		Book book1 = new Book();
		book1.setTitle("test2");
		book1.setAuthor("rana2");
		book1.setPrice(100.00);
		book1.setPages(201);
		book1.setDesc("for test2");


		Book book2 = new Book();
		book2.setTitle("test13");
		book2.setAuthor("rana3");
		book2.setPrice(100.00);
		book2.setPages(203);
		book2.setDesc("for test3");

		bookService.CreateBook(book);
		bookService.CreateBook(book1);
		bookService.CreateBook(book2);


	}
}
