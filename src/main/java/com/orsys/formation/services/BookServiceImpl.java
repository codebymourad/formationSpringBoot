package com.orsys.formation.services;

import com.orsys.formation.dao.BookDAO;
import com.orsys.formation.models.Book;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {
    private BookDAO bookDAO;

    @Autowired
    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }


    @Override
    public List<Book> getBooks() {
        return bookDAO.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookDAO.findById(id).orElseThrow(() -> new EntityNotFoundException("Book not found with ID : " + id));
    }

    @Override
    public Book addBook(Book book) {
        return bookDAO.save(new Book(book.getTitle(), book.getDescription(), book.getPublish()));
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
