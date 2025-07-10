package com.orsys.formation.services;

import com.orsys.formation.dto.request.BookRequestDTO;
import com.orsys.formation.dto.response.BookResponseDTO;
import com.orsys.formation.models.Book;

import java.util.List;
import java.util.stream.Stream;

public interface BookService {

   // List<Book> getBooks();
    Stream<BookResponseDTO> getBooks();

//    Book getBookById(Long id);
    BookResponseDTO getBookById(Long id);

//    Book addBook(Book book);
    BookResponseDTO addBook(BookRequestDTO book);

    Book updateBook(Book book, Long id);

    void deleteBookById(Long id);

    void deleteBooks();
}
