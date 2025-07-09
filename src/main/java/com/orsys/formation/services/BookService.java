package com.orsys.formation.services;

import com.orsys.formation.models.Book;

import java.util.List;

public interface BookService {

    List<Book> getBooks();

    Book getBookById(Long id);

    Book addBook(Book book);

    Book updateBook(Book book, Long id);

    void deleteBookById(Long id);

    void deleteBooks();
}
