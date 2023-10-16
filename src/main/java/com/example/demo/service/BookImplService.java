package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookImplService implements BookService{

    @Autowired
    BookRepositroy bookRepositroy;
    @Override
    public List<Book> GetAllBooks() {
        return bookRepositroy.findAll();
    }

    @Override
    public Optional<Book> getById(int id) {
        return bookRepositroy.findById(id);
    }

    @Override
    public Book CreateBook(Book book) {
        return bookRepositroy.save(book);
    }
}
