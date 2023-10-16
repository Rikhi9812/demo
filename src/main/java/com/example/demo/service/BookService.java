package com.example.demo.service;

import com.example.demo.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> GetAllBooks();

    Optional<Book> getById(int id);

    Book CreateBook(Book book);
}
