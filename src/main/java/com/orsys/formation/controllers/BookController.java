package com.orsys.formation.controllers;

import com.orsys.formation.dto.request.BookRequestDTO;
import com.orsys.formation.dto.response.BookResponseDTO;
import com.orsys.formation.models.Book;
import com.orsys.formation.services.BookService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping(path = "api/v1")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/hello")
    public String hello() {
        System.out.println("hello world ");
        return "hello world";
    }

    @GetMapping("/books")
    public ResponseEntity<?> getBooks() {
        try {
            // return new ResponseEntity<List<Book>>(bookService.getBooks(), HttpStatus.OK);
            return new ResponseEntity<Stream<BookResponseDTO>>(bookService.getBooks(), HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(" ERROR : " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id) {
        try {
//            return new ResponseEntity<Book>(bookService.getBookById(id), HttpStatus.OK);
            return new ResponseEntity<BookResponseDTO>(bookService.getBookById(id), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            System.out.println(" ERROR : " + e);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            System.out.println(" ERROR : " + e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/books")
    public ResponseEntity<?> addBook(@RequestBody BookRequestDTO book) {
        try {
//            return new ResponseEntity<Book>(bookService.addBook(book), HttpStatus.CREATED);
            return new ResponseEntity<BookResponseDTO>(bookService.addBook(book), HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(" ERROR : " + e);
            return new ResponseEntity<>("toto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/books/{id}")
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

    @DeleteMapping("/books/{id}")
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

    @DeleteMapping("/books")
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
