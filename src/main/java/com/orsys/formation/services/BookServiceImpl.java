package com.orsys.formation.services;

import com.orsys.formation.dao.BookDAO;
import com.orsys.formation.dao.CategoryDAO;
import com.orsys.formation.dto.request.BookRequestDTO;
import com.orsys.formation.dto.response.BookResponseDTO;
import com.orsys.formation.mappers.BookMapper;
import com.orsys.formation.models.Book;
import com.orsys.formation.models.Category;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Autowired
    private CategoryDAO categoryDAO;

    @Autowired
    private BookMapper bookMapper;

//    @Override
//    public List<Book> getBooks() {
//        return bookDAO.findAll();
//    }
    @Override
    public Stream<BookResponseDTO> getBooks() {
        List<Book> books = bookDAO.findAll();
        // return books.stream().map(bookMapper::toResponse);
        return books.stream().map(book -> bookMapper.toResponse(book));
    }

//    @Override
//    public Book getBookById(Long id) {
//        return bookDAO.findById(id).orElseThrow(() -> new EntityNotFoundException("Book not found with ID : " + id));
//    }
    @Override
    public BookResponseDTO getBookById(Long id) {
        BookResponseDTO book = bookDAO.findById(id).map(bookMapper::toResponse).orElseThrow(() -> new EntityNotFoundException("Book not found with ID : " + id));
        return book;
    }


//    @Override
//    public Book addBook(Book book) {
//        return bookDAO.save(new Book(book.getTitle(), book.getDescription(), book.getPublish()));
//    }
    @Override
    public BookResponseDTO addBook(BookRequestDTO book) {
        Category category = categoryDAO.findById(book.getCategory().getId()).orElseThrow(
                () -> new EntityNotFoundException("Category not found")
        );
        Book mapper = bookMapper.toEntity(book);
        mapper.setCategory(category);
        Book savedBook = bookDAO.save(mapper);
        return bookMapper.toResponse(savedBook);
    }

    @Override
    public Book updateBook(Book book, Long id) {
        Book myBook = bookDAO.findById(id).orElseThrow(() -> new EntityNotFoundException("Book not found with ID : " + id));

        myBook.setTitle(book.getTitle());
        myBook.setDescription(book.getDescription());
        myBook.setPublish(book.getPublish());

        return bookDAO.save(myBook);
    }

    @Override
    public void deleteBookById(Long id) {
        Book myBook = bookDAO.findById(id).orElseThrow(() -> new EntityNotFoundException("Book not found with ID : " + id));

        bookDAO.deleteById(id);
    }

    @Override
    public void deleteBooks() {
        bookDAO.deleteAll();
    }
}
