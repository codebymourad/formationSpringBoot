package com.orsys.formation.controllers;

import com.orsys.formation.models.Book;
import com.orsys.formation.services.BookService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController (BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/hello")
    public String hello() {
        System.out.println("hello wolrd ");
        return "hello wolrd";
    }

    @GetMapping(path = "/books")
    // public List<Book> getBooks() { return bookService.getBooks();}
    public ResponseEntity<?> getBooks() {
        try {
            return new ResponseEntity<List<Book>>(bookService.getBooks(), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(" ERROR : " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/books/{id}", produces = "application/json")
    public ResponseEntity<?> getBookById(@PathVariable Long id) {
        try {
            return new ResponseEntity<Book>(bookService.getBookById(id), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            System.out.println(" ERROR : " + e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            System.out.println(" ERROR : " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/books", produces = "application/json")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        try {
            return new ResponseEntity<Book>(bookService.addBook(book), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(" ERROR : " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/books/{id}", produces = "application/json")
    public ResponseEntity<?> updateBook(@PathVariable Long id, @RequestBody Book book) {
        try {
            return new ResponseEntity<Book>(bookService.updateBook(book, id), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            System.out.println(" ERROR : " + e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            System.out.println(" ERROR : " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/books/{id}", produces = "application/json")
    public ResponseEntity<?> deleteBookById(@PathVariable Long id) {
        try {
            bookService.deleteBookById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
            System.out.println(" ERROR : " + e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            System.out.println(" ERROR : " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(path = "/books", produces = "application/json")
    public ResponseEntity<?> deleteBooks() {
        try {
            bookService.deleteBooks();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            System.out.println(" ERROR : " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
