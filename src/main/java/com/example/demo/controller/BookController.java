package com.example.demo.controller;


import com.example.demo.entity.Book;
import com.example.demo.entity.BookInput;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @SchemaMapping(field = "allBooks", typeName = "Query")
    public List<Book> getAllBook() {
        return bookService.GetAllBooks();
    }


    @QueryMapping("getBook")
    public Optional<Book> getBook(@Argument int bookId) {
        return bookService.getById(bookId);
    }


    @MutationMapping("createBook")
    public Book Create(@Argument BookInput book) {

        Book b = new Book();
        b.setTitle(book.getTitle());
        b.setPages(book.getPages());
        b.setDesc(book.getDesc());
        b.setAuthor(book.getAuthor());
        b.setPrice(book.getPrice());
        return this.bookService.CreateBook(b);
    }


    @MutationMapping("updateBook")
    public Book update(@Argument BookInput book, @Argument int id) {

        Book b = this.bookService.getById(id).get();
        b.setTitle(book.getTitle());
        b.setPages(book.getPages());
        b.setDesc(book.getDesc());
        b.setAuthor(book.getAuthor());
        b.setPrice(book.getPrice());
        return this.bookService.CreateBook(b);
    }

    @MutationMapping("deleteBook")
    public String delete(@Argument int id) {
        Book b = this.bookService.getById(id).get();
        this.bookService.delete(b);
        return "deleted";
    }


}
